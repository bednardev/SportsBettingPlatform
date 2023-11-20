package com.sbs.models;

import java.util.Map;

public interface Odds {
    Map<String,Float> getOdds();

    void setOdds(Match match);


}
