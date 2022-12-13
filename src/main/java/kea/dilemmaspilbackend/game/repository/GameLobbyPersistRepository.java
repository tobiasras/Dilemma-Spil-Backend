package kea.dilemmaspilbackend.game.repository;

import kea.dilemmaspilbackend.game.model.persistmodel.GameLobbyPersist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameLobbyPersistRepository extends JpaRepository<GameLobbyPersist, Long> {
}
