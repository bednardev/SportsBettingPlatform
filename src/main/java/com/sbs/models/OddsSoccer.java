package com.sbs.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OddsSoccer implements Odds {

    private static final float afterRake = 0.95F;
    private float homeTeamOdd;
    //odd that home team/player will win
    private float awayTeamOdd;
    //odd that away team/player will win, 0.3 chance is always reserved for a draw
    private float drawOdd;
    //odd that there will be a draw

//    private float homeTeamCornersOdd; //odd that home team will have over 5.5 corner kicks in a game
//    private float awayTeamCornersOdd; //odd that home team will have over 5.5 corner kicks in a game

    @Override
    public List<Bet> getOdds(Match match) {
        return List.of(
                new Bet(match.getName(), "1", homeTeamOdd, BetStatus.IN_PROGRESS),
                new Bet(match.getName(), "X", drawOdd, BetStatus.IN_PROGRESS),
                new Bet(match.getName(), "2", awayTeamOdd, BetStatus.IN_PROGRESS)
//                new Bet("1 over 5.5 corners", homeTeamCornersOdd),
//                new Bet("2 over 5.5 corners", awayTeamCornersOdd)
        );
    }

    @Override
    public void setOdds(Match match) {
        homeTeamOdd = afterRake / match.getHomeChanceCoefficient();
        awayTeamOdd = afterRake / (0.7F - match.getHomeChanceCoefficient());
        drawOdd = afterRake / 0.3F;
    }
}
