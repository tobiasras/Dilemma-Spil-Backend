package kea.dilemmaspilbackend.admin.repository;

import kea.dilemmaspilbackend.admin.model.GameLobbyStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameStatRepository extends JpaRepository<GameLobbyStat, Long> {

}
