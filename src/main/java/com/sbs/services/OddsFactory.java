package com.sbs.services;

import com.sbs.models.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OddsFactory {
    private OddsBasketball oddsBasketball;
    private OddsSoccer oddsSoccer;
    private OddsTennis oddsTennis;

    public OddsFactory(OddsBasketball oddsBasketball, OddsSoccer oddsSoccer, OddsTennis oddsTennis) {
        this.oddsBasketball = oddsBasketball;
        this.oddsSoccer = oddsSoccer;
        this.oddsTennis = oddsTennis;
    }

    public List<Bet> createOdds(Match match) {
        return switch (match.getDiscipline()) {
            case SOCCER -> oddsSoccer.getOdds(match);
            case BASKETBALL -> oddsBasketball.getOdds(match);
            case TENNIS -> oddsTennis.getOdds(match);
        };
    }
    public void setOdds(Match match) {
        switch (match.getDiscipline()) {
            case SOCCER -> oddsSoccer.setOdds(match);
            case BASKETBALL -> oddsBasketball.setOdds(match);
            case TENNIS -> oddsTennis.setOdds(match);
        };
    }
}
