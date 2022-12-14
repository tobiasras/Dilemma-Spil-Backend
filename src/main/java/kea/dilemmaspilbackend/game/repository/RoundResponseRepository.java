package kea.dilemmaspilbackend.game.repository;

import kea.dilemmaspilbackend.game.model.RoundResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoundResponseRepository extends JpaRepository<RoundResponse, Long> {
    List<RoundResponse> getRoundResponseByDilemma_Id(int dilemmaID);
}
