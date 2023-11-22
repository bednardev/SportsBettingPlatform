package com.sbs.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OddsTennis implements Odds {

    private static final float afterRake = 0.95F;
    private float homeTeamOdd;
    //odd that home team/player will win
    private float awayTeamOdd;
    //odd that away team/player will win

//    private float homeTeamAcesOdd; //odd that home player will have over 8.5 service aces in a game
//    private float awayTeamAcesOdd; //odd that away player will have over 8.5 service aces in a game

    @Override
    public List<Bet> getOdds(Match match) {
        return List.of(
                new Bet(match.getName(), "1", homeTeamOdd, BetStatus.IN_PROGRESS),
                new Bet(match.getName(), "2", awayTeamOdd, BetStatus.IN_PROGRESS)
//                new Bet("1 over 8.5 aces", homeTeamAcesOdd),
//                new Bet("2 over 8.5 aces", awayTeamAcesOdd)
        );
    }

    @Override
    public void setOdds(Match match) {
        homeTeamOdd = afterRake / match.getHomeChanceCoefficient();
        awayTeamOdd = afterRake / (1 - match.getHomeChanceCoefficient());
    }

}
