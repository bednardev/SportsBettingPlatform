package com.SBS.Repositories;

import com.SBS.Models.Match;

import java.util.List;

public interface MatchRepository {
    Match addMatch(Match match);

    void removeMatch(Long id);

    Match findById(Long id);

    List<Match> getMatches();

}
