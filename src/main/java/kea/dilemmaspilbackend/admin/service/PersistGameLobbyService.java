package kea.dilemmaspilbackend.admin.service;

import kea.dilemmaspilbackend.game.model.RoundResponse;
import kea.dilemmaspilbackend.game.model.persistmodel.GameLobbyPersist;
import kea.dilemmaspilbackend.game.repository.GameLobbyPersistRepository;
import kea.dilemmaspilbackend.game.repository.RoundResponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PersistGameLobbyService {
    private GameLobbyPersistRepository gameLobbyPersistRepository;
    private RoundResponseRepository roundResponseRepository;

    public List<GameLobbyPersist> getAllFinishedGames() {
        return gameLobbyPersistRepository.findAll();
    }

    public List<RoundResponse> getResponseByDilemma(int dilemmaID) {
        return roundResponseRepository.getRoundResponseByDilemma_Id(dilemmaID);
    }
}
