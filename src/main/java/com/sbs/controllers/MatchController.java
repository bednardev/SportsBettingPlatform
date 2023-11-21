package com.sbs.controllers;

import com.sbs.models.Match;
import com.sbs.models.MatchDto;
import com.sbs.models.MatchResult;
import com.sbs.services.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<MatchDto> getMatches() {
        return matchService.getMatches();
    }

    @PostMapping
    public Match addMatch(@RequestBody Match match) {
        return matchService.addMatch(match);
    }

    @PatchMapping("/{id}/{matchResult}")
    public Match setResult(@PathVariable Long id, @PathVariable MatchResult matchResult) {
        return matchService.setResult(id, matchResult);
    }
}
