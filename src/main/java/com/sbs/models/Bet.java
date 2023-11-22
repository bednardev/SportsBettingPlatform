package com.sbs.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Bet {
    private String matchName;
    private String name;
    private Float course;
    private BetStatus betStatus;
}
