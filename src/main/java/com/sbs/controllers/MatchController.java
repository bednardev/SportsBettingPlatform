package com.sbs.controllers;

import com.sbs.models.Match;
import com.sbs.models.MatchDto;
import com.sbs.models.MatchResult;
import com.sbs.services.MatchService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public Match findById(@PathVariable Long id) {
        return matchService.findById(id);
    }

    @PostMapping
    public Match addMatch(@RequestBody @Valid Match match) {
        return matchService.addMatch(match);
    }

    @PatchMapping(value = "/{id}/{matchResult}", params = "settle")
    public Match setResult(@PathVariable Long id, @PathVariable MatchResult matchResult) {
        return matchService.setResult(id, matchResult);
    }

    @DeleteMapping("/{id}")
    public void removeMatch(@PathVariable Long id) {
        matchService.removeMatch(id);
    }
}
