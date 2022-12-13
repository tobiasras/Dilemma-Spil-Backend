package kea.dilemmaspilbackend.game.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NextCardResponse {



    private String message;
    private int currentRound;
    private boolean gameIsDone;



}
