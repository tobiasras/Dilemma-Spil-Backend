package kea.dilemmaspilbackend.admin.service;

import kea.dilemmaspilbackend.game.model.persistmodel.GameLobbyPersist;
import kea.dilemmaspilbackend.game.repository.GameLobbyPersistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PersistGameLobbyService {
    private GameLobbyPersistRepository gameLobbyPersistRepository;

    public List<GameLobbyPersist> getAllFinishedGames() {
        return gameLobbyPersistRepository.findAll();
    }
}
