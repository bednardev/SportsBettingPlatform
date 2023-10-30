package com.SBS.Models;

import lombok.Getter;
import lombok.Setter;

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
  //      odds = oddsFactory.createOdds(discipline);
    }
}