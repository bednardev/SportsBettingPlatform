package com.SBS.Models;

import com.SBS.Models.Bet;
import com.SBS.Models.Odds;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class OddsBasketball implements Odds {
    private static final float afterRake = 0.9F;
    private float homeTeamOdd;
    //odd that home team/player will win
    private float awayTeamOdd;
    //odd that away team/player will win

//   private float homeTeamPointsOdd;  //odd that home team will have over 80.5 points in a game
//   private float awayTeamPointsOdd;  //odd that away team will have over 80.5 points in a game

    @Override
    public List<Bet> getOdds() {
        return List.of(
                new Bet("1", homeTeamOdd),
                new Bet("2", awayTeamOdd)
                //               new Bet("1 over 80.5 points", homeTeamPointsOdd),
                //               new Bet("2 over 80.5 points", awayTeamPointsOdd)
        );
    }
    @Override
    public void setOdds(Match match) {
        homeTeamOdd = afterRake * 1F / match.getHomeChancePercentage();
        awayTeamOdd = afterRake * 1F / (1 - match.getHomeChancePercentage());
    }
}
