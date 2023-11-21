package com.sbs.models;

import java.time.Instant;
import java.util.List;

public record MatchDto (
        Long id,
        Discipline discipline,
        String name,
        Instant date,
        MatchResult result,
        List<Bet> odds) {
}
