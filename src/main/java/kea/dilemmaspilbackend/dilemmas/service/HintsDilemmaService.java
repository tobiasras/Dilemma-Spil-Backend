package kea.dilemmaspilbackend.dilemmas.service;

import kea.dilemmaspilbackend.dilemmas.model.HintsDilemmaModel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class HintsDilemmaService implements CrudInterface<HintsDilemmaModel, Integer> {
    @Override
    public Set<HintsDilemmaModel> findAll() {
        return null;
    }

    @Override
    public HintsDilemmaModel save(HintsDilemmaModel object) {
        return null;
    }

    @Override
    public void delete(HintsDilemmaModel object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Optional<HintsDilemmaModel> findById(Integer integer) {
        return Optional.empty();
    }
}
