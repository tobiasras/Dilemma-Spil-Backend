package kea.dilemmaspilbackend.admin.service;

import kea.dilemmaspilbackend.admin.model.GameLobbyStat;
import kea.dilemmaspilbackend.admin.repository.GameStatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {
    private GameStatRepository gameStatRepository;
    public List<GameLobbyStat> getAllGameLobbies() {
        return gameStatRepository.findAll();
    }

    public void saveGameLobbyStat(GameLobbyStat gameLobbyStat) {
        gameStatRepository.save(gameLobbyStat);
    }
}
