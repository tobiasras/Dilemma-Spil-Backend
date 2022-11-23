package kea.dilemmaspilbackend.dilemmas.service;

import kea.dilemmaspilbackend.dilemmas.model.DilemmaModel;

import java.util.Optional;
import java.util.Set;

public class DilemmaService implements CrudInterface<DilemmaModel, Integer> {
    @Override
    public Set<DilemmaModel> findAll() {
        return null;
    }

    @Override
    public DilemmaModel save(DilemmaModel object) {
        return null;
    }

    @Override
    public void delete(DilemmaModel object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Optional<DilemmaModel> findById(Integer integer) {
        return Optional.empty();
    }
}
