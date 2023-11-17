package com.SBS.Models;

import com.SBS.Models.Bet;

import java.util.List;

public interface Odds {
    List<Bet> getOdds();

    void setOdds(Match match);


}
