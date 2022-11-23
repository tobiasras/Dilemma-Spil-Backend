package kea.dilemmaspilbackend.dilemmas.service;

import kea.dilemmaspilbackend.dilemmas.model.GameAnswersModel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GameAnswersService implements CrudInterface<GameAnswersModel, Integer> {
    @Override
    public Set<GameAnswersModel> findAll() {
        return null;
    }

    @Override
    public GameAnswersModel save(GameAnswersModel object) {
        return null;
    }

    @Override
    public void delete(GameAnswersModel object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Optional<GameAnswersModel> findById(Integer integer) {
        return Optional.empty();
    }
}
