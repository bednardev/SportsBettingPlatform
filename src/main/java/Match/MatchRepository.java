package Match;

import Match.Match;

public interface MatchRepository {
    Match addMatch(Match match);

    void removeMatch(Long id);

    Match getMatchById(Long id);


}
