package com.SBS.Services;

import com.SBS.Models.*;
import com.SBS.Repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final OddsFactory oddsFactory;

    MatchService(MatchRepository matchRepository, OddsFactory oddsFactory) {
        this.matchRepository = matchRepository;
        this.oddsFactory = oddsFactory;
    }

    public Match addMatch(Match match) {
        Match matchToAdd = new Match(match.getDiscipline(), match.getHomeTeam(), match.getAwayTeam(), match.getDate(), match.getHomeChancePercentage(), oddsFactory.createOdds(match));
        oddsFactory.setOdds(matchToAdd);
        return matchRepository.addMatch(matchToAdd);
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

    public Match setResult(Long id,MatchResult matchResult)
    {
        Match match = matchRepository.getMatchById(id);
        match.setResult(matchResult);
        return match;
    }
}
