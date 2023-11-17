package com.SBS.Models;

import com.SBS.Models.Bet;
import com.SBS.Models.Odds;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OddsTennis implements Odds {

    private static final float afterRake = 0.9F;
    private float homeTeamOdd;
    //odd that home team/player will win
    private float awayTeamOdd;
    //odd that away team/player will win

//    private float homeTeamAcesOdd; //odd that home player will have over 8.5 service aces in a game
//    private float awayTeamAcesOdd; //odd that away player will have over 8.5 service aces in a game

    @Override
    public List<Bet> getOdds() {
        return List.of(
                new Bet("1", homeTeamOdd),
                new Bet("2", awayTeamOdd)
//                new Bet("1 over 8.5 aces", homeTeamAcesOdd),
//                new Bet("2 over 8.5 aces", awayTeamAcesOdd)
        );
    }

    @Override
    public void setOdds(Match match) {
        homeTeamOdd = afterRake * 1F / match.getHomeChanceCoefficient();
        awayTeamOdd = afterRake * 1F / (1 - match.getHomeChanceCoefficient());
    }

}
