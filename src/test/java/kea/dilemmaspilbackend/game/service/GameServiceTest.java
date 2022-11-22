package kea.dilemmaspilbackend.game.service;

import kea.dilemmaspilbackend.game.model.GameLobby;
import kea.dilemmaspilbackend.game.model.Player;
import kea.dilemmaspilbackend.game.repository.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    GameService gameService;
    GameRepository gameRepository;

    @BeforeEach // kaldes før hver @Test
    public void setUp()  {
        gameRepository = new GameRepository();
        gameService = new GameService(gameRepository);
    }

    @Test
    public void testCreateLobby(){
        // Tests if a lobby is added to the game lobby list by checking if the lobby code works as a key in the list.
        Player player = new Player();
        String lobbyCode = gameService.createGameLobby(player);
        Assertions.assertNotNull(gameRepository.getGameLobbyList().get(lobbyCode));
    }
}
