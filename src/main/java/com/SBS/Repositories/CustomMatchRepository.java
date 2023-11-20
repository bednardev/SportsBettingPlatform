package com.SBS.Repositories;

import com.SBS.Models.Match;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


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
    public Match findById(Long id) {
        return matches.get(id);
    }

    @Override
    public List<Match> getMatches() {
        return new LinkedList<>(matches.values());
    }
}
