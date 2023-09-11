package Models;

import Models.MatchResult;
import Models.Team;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Match {
    private long id;
    private Discipline discipline;
    private Team homeTeam;
    private Team awayTeam;
    private Instant date;
    private Odds odds;
    private MatchResult result;

    public Match(Discipline discipline, Team homeTeam, Team awayTeam, Instant date, Odds odds) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.odds = odds;
    }
}