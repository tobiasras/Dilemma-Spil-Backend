package kea.dilemmaspilbackend.admin.repository;

import kea.dilemmaspilbackend.game.model.GameLobbyLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameStatRepository extends JpaRepository<GameLobbyLogger, Long> {

}
