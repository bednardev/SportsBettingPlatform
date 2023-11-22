package com.sbs.models;

public enum MatchResult {
    TO_BE_FINISHED("TBF"),
    HOME_WIN("1"),
    DRAW("X"),
    AWAY_WIN("2");

    private String score;

    MatchResult(String score){
        this.score = score;
    }

    public String getScore(){
        return score;
    }
}
