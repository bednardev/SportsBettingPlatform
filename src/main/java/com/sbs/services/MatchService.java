package com.sbs.services;

import com.sbs.models.*;
import com.sbs.repositories.MatchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final OddsFactory oddsFactory;

    public MatchService(MatchRepository matchRepository, OddsFactory oddsFactory) {
        this.matchRepository = matchRepository;
        this.oddsFactory = oddsFactory;
    }

    public Match addMatch(Match match) {
        oddsFactory.setOdds(match);
        Match matchToAdd = new Match(match.getDiscipline(), match.getHomeTeam(), match.getAwayTeam(), match.getDate(), match.getHomeChanceCoefficient(), oddsFactory.createOdds(match));
        return matchRepository.addMatch(matchToAdd);
    }

    public void removeMatch(Long id) {
        matchRepository.removeMatch(id);
    }

    public Match findById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Match> getMatches() {
        return matchRepository.getMatches();
    }

    public Match setResult(Long id,MatchResult matchResult)
    {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        match.setResult(matchResult);
        return match;
    }
}
