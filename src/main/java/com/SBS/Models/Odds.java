package com.SBS.Models;

import java.util.List;
import java.util.Map;

public interface Odds {
    Map<String,Float> getOdds();

    void setOdds(Match match);


}
