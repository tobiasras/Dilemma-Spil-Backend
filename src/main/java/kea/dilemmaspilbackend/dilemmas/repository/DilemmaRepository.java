package kea.dilemmaspilbackend.dilemmas.repository;


import kea.dilemmaspilbackend.dilemmas.model.DilemmaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DilemmaRepository extends JpaRepository<DilemmaModel, Integer> {
}
