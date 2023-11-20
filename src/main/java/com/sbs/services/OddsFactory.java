package com.sbs.services;

import com.sbs.models.*;
import org.springframework.stereotype.Service;

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

    public Map<String,Float> createOdds(Match match) {
        return switch (match.getDiscipline()) {
            case SOCCER -> oddsSoccer.getOdds();
            case BASKETBALL -> oddsBasketball.getOdds();
            case TENNIS -> oddsTennis.getOdds();
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
