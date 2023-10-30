package com.SBS.Services;

import com.SBS.Models.Match;
import com.SBS.Repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    MatchRepository matchRepository;

    MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match addMatch(Match match) {
        return matchRepository.addMatch(match);
    }

    public void removeMatch(Long id) {
        matchRepository.removeMatch(id);
    }

    public Match getMatchById(Long id) {
        return matchRepository.getMatchById(id);
    }

    public List<Match> getMatches() {
        return matchRepository.getMatches();
    }
}
