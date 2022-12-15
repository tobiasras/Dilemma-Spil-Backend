package kea.dilemmaspilbackend.game.model;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@ToString
@Data
public class GameLobby {

    private Date timeCreated;
    private String lobbyCode;
    private List<Player> playerList;
    private CardPackageModel cardPackage;
    private int currentRound;
    private int totalRounds;

    public Date getTimeCreated() {
        return timeCreated;
    }

    public GameLobby(CardPackageModel cardPackage, Player player) {
        this.timeCreated = Date.from(Instant.now());

        this.lobbyCode = createLobbyCode();
        this.playerList = new ArrayList<>();
        this.cardPackage = cardPackage;
        this.totalRounds = cardPackage.getDilemmaModels().size();
        addPlayer(player);
        currentRound = -1;
    }

    public void addPlayer(Player player){
        playerList.add(player);
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
        //int numberOfReadyPlayers = (int) playerList.stream().filter(Player::isReady).count();
        //if (playerList.size() == numberOfReadyPlayers)
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
