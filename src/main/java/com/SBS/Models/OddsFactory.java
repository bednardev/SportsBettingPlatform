package com.SBS.Models;

import java.util.List;

public class OddsFactory {
    private OddsBasketball oddsBasketball;
    private OddsSoccer oddsSoccer;
    private OddsTennis oddsTennis;
    private Discipline discipline;
    private List<Bet> odds;

    public List<Bet> createOdds(Discipline discipline) {
        return switch (discipline) {
            case SOCCER -> oddsSoccer.getOdds();
            case BASKETBALL -> oddsBasketball.getOdds();
            case TENNIS -> oddsTennis.getOdds();
        };
    }
}
