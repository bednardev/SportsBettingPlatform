package com.sbs.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NotNull
    private Discipline discipline;
    @NotEmpty
    private String homeTeam;
    @NotEmpty
    private String awayTeam;
    private String name;
    @NotNull
    private Instant date;
    @NotNull
    private Float homeChanceCoefficient;
    /*a chance for winning for home Team, should be provided after game analysis. Away team chance is calculated
     then based on provided home chance (for soccer, a draw chance has fixed value 0.30)*/
    private MatchResult result;
    @OneToMany(mappedBy = "betId")
    private List<Bet> odds;

    public Match(Discipline discipline, String homeTeam, String awayTeam, Instant date, Float homeChanceCoefficient, List<Bet> odds) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.name = homeTeam + " - " + awayTeam;
        this.date = date;
        this.homeChanceCoefficient = homeChanceCoefficient;
        this.result = MatchResult.NOT_STARTED;
        this.odds = odds;
    }

    public Match() {

    }

    public Optional<Bet> findBetByName(String betName) {
        return getOdds()
                .stream()
                .filter(b -> betName.equals(b.getName()))
                .findFirst();
    }

    public void settleBetStatus(MatchResult matchResult) {
        getOdds().forEach(bet -> {
                    if (bet.getName().equals(matchResult.getScore())) {
                        bet.setBetStatus(BetStatus.WON);
                    } else {
                        bet.setBetStatus(BetStatus.LOST);
                    }
                });
    }
}