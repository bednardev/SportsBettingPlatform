package com.sbs.models;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OddsBasketball implements Odds {
    private static final float afterRake = 0.95F;
    private float homeTeamOdd;
    //odd that home team/player will win
    private float awayTeamOdd;
    //odd that away team/player will win

//   private float homeTeamPointsOdd;  //odd that home team will have over 80.5 points in a game
//   private float awayTeamPointsOdd;  //odd that away team will have over 80.5 points in a game

    @Override
    public Map<String,Float> getOdds() {
        return Map.of(
                "1", homeTeamOdd,
                "2", awayTeamOdd
                //               new Bet("1 over 80.5 points", homeTeamPointsOdd),
                //               new Bet("2 over 80.5 points", awayTeamPointsOdd)
        );
    }
    @Override
    public void setOdds(Match match) {
        homeTeamOdd = afterRake * 1F / match.getHomeChanceCoefficient();
        awayTeamOdd = afterRake * 1F / (1 - match.getHomeChanceCoefficient());
    }
}
