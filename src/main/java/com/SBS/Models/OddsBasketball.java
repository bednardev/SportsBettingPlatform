package com.SBS.Models;

import com.SBS.Models.Bet;
import com.SBS.Models.Odds;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class OddsBasketball implements Odds {
    private float homeTeamOdd = 1.90F; //odd that home team/player will win
    private float awayTeamOdd = 1.90F; //odd that away team/player will win
//    private float homeTeamPointsOdd;  //odd that home team will have over 80.5 points in a game
//    private float awayTeamPointsOdd;  //odd that away team will have over 80.5 points in a game

    @Override
    public List<Bet> getOdds() {
        return List.of(
                new Bet("1", homeTeamOdd),
                new Bet("2", awayTeamOdd)
 //               new Bet("1 over 80.5 points", homeTeamPointsOdd),
 //               new Bet("2 over 80.5 points", awayTeamPointsOdd)
        );
    }
}
