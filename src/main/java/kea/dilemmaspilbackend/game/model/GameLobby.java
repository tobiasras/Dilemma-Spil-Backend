package kea.dilemmaspilbackend.game.model;

import lombok.Data;

import java.util.List;

@Data
public class GameLobby {
    private String lobbyCode;
    private List<Player> playerList;
    private int currentRound;
}
