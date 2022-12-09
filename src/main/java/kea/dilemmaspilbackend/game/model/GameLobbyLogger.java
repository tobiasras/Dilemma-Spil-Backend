package kea.dilemmaspilbackend.game.model;

import kea.dilemmaspilbackend.game.model.persistmodel.GameLobbyPersist;
import kea.dilemmaspilbackend.game.repository.GameLobbyPersistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// This class stores all relevant, statistical information related to a game.
@Component
public class GameLobbyLogger {
    @Autowired
    GameLobbyPersistRepository gameLobbyPersistRepository;
    public void log(GameLobby gameLobby)  {
        gameLobbyPersistRepository.save(new GameLobbyPersist(gameLobby));
    }
}
