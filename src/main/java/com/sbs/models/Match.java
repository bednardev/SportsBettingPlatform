package com.sbs.models;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
public class Match {
    private long id;
    private Discipline discipline;
    private String homeTeam;
    private String awayTeam;
    private Instant date;
    private Float homeChanceCoefficient;
    /*a chance for winning for home Team, should be provided after game analysis. Away team chance is calculated
     then based on provided home chance (for soccer, a draw chance has fixed value 0.30)*/
    private MatchResult result = MatchResult.TO_BE_FINISHED;
    private Map<String, Float> odds;

    public Match(Discipline discipline, String homeTeam, String awayTeam, Instant date, Float homeChanceCoefficient, Map<String,Float> odds) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.homeChanceCoefficient = homeChanceCoefficient;
        this.odds = odds;
    }
}