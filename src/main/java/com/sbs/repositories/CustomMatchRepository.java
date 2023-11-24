package com.sbs.repositories;

import com.sbs.models.Match;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class CustomMatchRepository implements MatchRepository {
    private Map<Long, Match> matches = new HashMap<>();
    private Long id = 0L;

    @Override
    public Match addMatch(Match match) {
        match.setId(id);
        matches.put(id, match);
        id += 1;
        return match;
    }

    @Override
    public void removeMatch(Long id) {
        matches.remove(id);
    }

    @Override
    public Optional<Match> findById(Long id) {
        return matches.containsKey(id) ? Optional.of(matches.get(id)) : Optional.empty();
    }

    @Override
    public List<Match> getMatches() {
        return new LinkedList<>(matches.values());
    }
}
