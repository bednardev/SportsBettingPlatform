package Match;

import Match.Match;
import Match.MatchRepository;

import java.util.HashMap;
import java.util.Map;

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
    public Match getMatchById(Long id) {
        return matches.get(id);
    }
}
