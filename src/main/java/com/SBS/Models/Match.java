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
    private MatchResult result = MatchResult.TO_BE_FINISHED;
    private List<Bet> odds;
    private OddsFactory oddsFactory;

    Match(Discipline discipline, String homeTeam, String awayTeam, Instant date) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
//      this.odds = oddsFactory.createOdds(discipline);
    }
}