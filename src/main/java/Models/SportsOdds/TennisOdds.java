package Models.SportsOdds;

import Models.Odds;

public class TennisOdds extends Odds {

    private float homeTeamAcesOdds; //odd that home player will have over 8 service aces in a game
    private float awayTeamAcesOdds; //odd that away player will have over 8 service aces in a game

    public TennisOdds(float homeTeamOdds, float awayTeamOdds, float homeTeamAcesOdds, float awayTeamAcesOdds) {
        super(homeTeamOdds, awayTeamOdds);
        this.homeTeamAcesOdds = homeTeamAcesOdds;
        this.awayTeamAcesOdds = awayTeamAcesOdds;
    }

}
