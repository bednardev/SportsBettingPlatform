package com.sbs.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@AllArgsConstructor
@Getter
@Setter
public class Bet {
    private String matchName;
    private String name;
    private Float course;
    private BetStatus betStatus;
}
