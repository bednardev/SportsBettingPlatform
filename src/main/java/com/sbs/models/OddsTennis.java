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

    @Override
    public List<Bet> getOdds(Match match) {
        return List.of(
                new Bet(0L,match.getName(), "1", homeTeamOdd, BetStatus.NOT_STARTED),
                new Bet(1L,match.getName(), "2", awayTeamOdd, BetStatus.NOT_STARTED)
        );
    }

    @Override
    public void setOdds(Match match) {
        homeTeamOdd = afterRake / match.getHomeChanceCoefficient();
        awayTeamOdd = afterRake / (1 - match.getHomeChanceCoefficient());
    }

}
