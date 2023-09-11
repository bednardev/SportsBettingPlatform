package Models.SportsOdds;

import Models.Odds;

public class BasketballOdds extends Odds {

    private float homeTeamPoints;  //odd that home team will have over 80 points in a game
    private float awayTeamPoints;  //odd that away team will have over 80 points in a game
    public BasketballOdds(float homeTeamOdds, float awayTeamOdds, float homeTeamPoints, float awayTeamPoints) {
        super(homeTeamOdds, awayTeamOdds);
        this.homeTeamPoints = homeTeamPoints;
        this.awayTeamPoints = awayTeamPoints;
    }
}
