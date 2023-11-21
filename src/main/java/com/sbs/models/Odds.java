package com.sbs.models;

import java.util.List;

public interface Odds {
    List<Bet> getOdds(Match match);

    void setOdds(Match match);


}
