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
    @Override
    public List<Bet> getOdds(Match match) {
        return List.of(
                new Bet(0L,match.getName(), "1", homeTeamOdd, BetStatus.NOT_STARTED),
                new Bet(1L,match.getName(), "X", drawOdd, BetStatus.NOT_STARTED),
                new Bet(2L, match.getName(), "2", awayTeamOdd, BetStatus.NOT_STARTED)
        );
    }

    @Override
    public void setOdds(Match match) {
        homeTeamOdd = afterRake / match.getHomeChanceCoefficient();
        awayTeamOdd = afterRake / (0.7F - match.getHomeChanceCoefficient());
        drawOdd = afterRake / 0.3F;
    }
}
