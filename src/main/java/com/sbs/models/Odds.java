package com.sbs.models;

import java.util.List;
import java.util.Map;

public interface Odds {
    List<Bet> getOdds(Match match);

    void setOdds(Match match);


}
