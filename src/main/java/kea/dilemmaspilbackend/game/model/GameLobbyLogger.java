package kea.dilemmaspilbackend.game.model;

import kea.dilemmaspilbackend.game.model.persistmodel.GameLobbyPersist;
import kea.dilemmaspilbackend.game.service.GameLobbyLoggerService;
import org.springframework.stereotype.Component;

// This class stores all relevant, statistical information related to a game.
@Component
public class GameLobbyLogger {

    private final GameLobbyLoggerService service;

    public GameLobbyLogger(GameLobbyLoggerService service) {
        this.service = service;
    }

    public void log(GameLobby gameLobby)  {
        service.save(new GameLobbyPersist(gameLobby));
    }
}
