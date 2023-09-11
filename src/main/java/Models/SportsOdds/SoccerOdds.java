package Models.SportsOdds;

import Models.Odds;

public class SoccerOdds extends Odds {

    private float drawOdds; //odd that there will be a draw
    private float homeTeamCornersOdds; //odd that home team will have over 5 corner kicks in a game
    private float awayTeamCornersOdds; //odd that home team will have over 5 corner kicks in a game

    public SoccerOdds(float homeTeamOdds, float drawOdds, float awayTeamOdds, float homeTeamCornersOdds, float awayTeamCornersOdds) {
        super(homeTeamOdds, awayTeamOdds);
        this.drawOdds = drawOdds;
        this.homeTeamCornersOdds = homeTeamCornersOdds;
        this.awayTeamCornersOdds = awayTeamCornersOdds;
    }
}
