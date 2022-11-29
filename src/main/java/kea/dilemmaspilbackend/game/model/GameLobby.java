package kea.dilemmaspilbackend.game.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class GameLobby {
    private String lobbyCode;
    private List<Player> playerList;
    private int currentRound;

    public GameLobby() {
        lobbyCode = createLobbyCode();
        playerList = new ArrayList<>();
        currentRound = -1;
    }

    private String createLobbyCode() {
        // Code found at https://www.baeldung.com/java-random-string
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public void advanceGame() {
        int numberOfReadyPlayers = (int) playerList.stream().filter(Player::isReady).count();
        if (playerList.size() == numberOfReadyPlayers)
            currentRound++;
    }

    public void readyUp(Player player) {
        for(Player player1: playerList) {
            if (player1.getName().equals(player.getName()))
                player1.setReady(true);
        }
        advanceGame();
    }
}
