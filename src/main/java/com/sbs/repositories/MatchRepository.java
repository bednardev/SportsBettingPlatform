package com.sbs.repositories;

import com.sbs.models.Match;

import java.util.List;
import java.util.Optional;

public interface MatchRepository {
    Match addMatch(Match match);

    void removeMatch(Long id);

    Optional<Match> findById(Long id);

    List<Match> getMatches();

}
