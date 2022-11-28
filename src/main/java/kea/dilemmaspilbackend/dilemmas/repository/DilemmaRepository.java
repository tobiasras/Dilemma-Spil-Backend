package kea.dilemmaspilbackend.dilemmas.repository;


import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.dilemmas.model.DilemmaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DilemmaRepository extends JpaRepository<DilemmaModel, Integer> {

    List<DilemmaModel> findDilemmaModelByCardPackageModelsId(Integer cardPackageId);
}
