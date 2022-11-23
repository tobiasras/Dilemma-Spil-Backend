package kea.dilemmaspilbackend.dilemmas.service;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CardPackageService implements CrudInterface<CardPackageModel, Integer>{
    @Override
    public Set<CardPackageModel> findAll() {
        return null;
    }

    @Override
    public CardPackageModel save(CardPackageModel object) {
        return null;
    }

    @Override
    public void delete(CardPackageModel object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Optional<CardPackageModel> findById(Integer integer) {
        return Optional.empty();
    }
}
