package com.SBS.Models;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OddsFactory {
    private OddsBasketball oddsBasketball;
    private OddsSoccer oddsSoccer;
    private OddsTennis oddsTennis;

    public OddsFactory(OddsBasketball oddsBasketball, OddsSoccer oddsSoccer, OddsTennis oddsTennis){
        this.oddsBasketball = oddsBasketball;
        this.oddsSoccer = oddsSoccer;
        this.oddsTennis = oddsTennis;
    }

    public List<Bet> createOdds(Discipline discipline) {
        return switch (discipline) {
            case SOCCER -> oddsSoccer.getOdds();
            case BASKETBALL -> oddsBasketball.getOdds();
            case TENNIS -> oddsTennis.getOdds();
        };
    }
}
