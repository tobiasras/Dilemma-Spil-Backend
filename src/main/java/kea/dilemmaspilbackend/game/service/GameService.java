package kea.dilemmaspilbackend.game.service;

import kea.dilemmaspilbackend.game.model.GameLobby;
import kea.dilemmaspilbackend.game.model.Player;
import kea.dilemmaspilbackend.game.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    GameRepository gameRepository;

    public void createGameLobby(Player player) {
        GameLobby gameLobby = new GameLobby();
        gameLobby.getPlayerList().add(player);
        gameRepository.getGameLobbyList().put(gameLobby.getLobbyCode(), gameLobby);
    }

    public void joinGameLobby(Player player, String lobbyCode) {
        GameLobby gameLobby = gameRepository.getGameLobbyList().get(lobbyCode);
        gameLobby.getPlayerList().add(player);
    }

    public void removeGameLobby(String lobbyCode) {
        gameRepository.getGameLobbyList().remove(lobbyCode);
    }

    public void leaveGameLobby(Player player, String lobbyCode) {
        List<Player> playerList = gameRepository.getGameLobbyList().get(lobbyCode).getPlayerList();
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getName().equals(player.getName())) {
                playerList.remove(i);
                return;
            }
        }
    }

    public void readyUp(Player player, String lobbyCode) {
        GameLobby gameLobbyList = gameRepository.getGameLobbyList().get(lobbyCode);
        gameLobbyList.readyUp(player);
    }
}
