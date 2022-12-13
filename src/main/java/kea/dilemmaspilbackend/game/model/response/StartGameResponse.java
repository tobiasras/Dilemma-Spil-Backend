package kea.dilemmaspilbackend.game.model.response;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.game.model.GameLobby;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StartGameResponse {


    private GameLobby gameLobby;
    private CardPackageModel cardPackage;
    private String message;
    private int currentRound;


}
