package com.SBS.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class Match {
    private long id;
    private Discipline discipline;
    private String homeTeam;
    private String awayTeam;
    private Instant date;
    private Long homeChancePercentage;
    /*a chance for winning for home Team, should be provided after game analysis. Away team chance is calculated
     then based on provided home chance (for soccer, a draw chance has fixed value)*/
    private MatchResult result = MatchResult.TO_BE_FINISHED;
    private List<Bet> odds;

    public Match(Discipline discipline, String homeTeam, String awayTeam, Instant date, Long homeChancePercentage, List<Bet> odds) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.homeChancePercentage = homeChancePercentage;
        this.odds = odds;
    }
}