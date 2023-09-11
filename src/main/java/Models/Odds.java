package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Odds {
    private float homeTeamOdds; //odd that home team/player will win
    private float awayTeamOdds; //odd that away team/player will win
}
