package com.sbs.services;

import com.sbs.models.*;
import com.sbs.repositories.MatchRepository;
import com.sbs.utils.Exceptions.MatchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<Match> findById(Long id) {
        return matchRepository.findById(id);
    }

    public List<MatchDto> getMatches() {
        return matchRepository.getMatches()
                .stream()
                .map(match -> new MatchDto(match.getId(), match.getDiscipline(), match.getName(), match.getDate(), match.getResult(), match.getOdds()))
                .collect(Collectors.toList());
    }

    public Match setResult(Long id, MatchResult matchResult) {
        Match match = matchRepository.findById(id)
                .orElseThrow(MatchNotFoundException::new);
        match.setResult(matchResult);
        match.settleBetStatus(matchResult);
        return match;
    }
}
