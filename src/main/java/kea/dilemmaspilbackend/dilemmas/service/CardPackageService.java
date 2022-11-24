package kea.dilemmaspilbackend.dilemmas.service;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.dilemmas.repository.CardPackageRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CardPackageService implements CrudInterface<CardPackageModel, Integer>{

    private CardPackageRepository cardPackageRepository;

    CardPackageService(CardPackageRepository cardPackageRepository){
        this.cardPackageRepository = cardPackageRepository;
    }

    @Override
    public Set<CardPackageModel> findAll() {
        Set<CardPackageModel> set = new HashSet<>(cardPackageRepository.findAll());
        return set;
    }

    @Override
    public CardPackageModel save(CardPackageModel object) {
        return cardPackageRepository.save(object);
    }

    @Override
    public void delete(CardPackageModel object) {
        cardPackageRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        cardPackageRepository.deleteById(integer);
    }

    @Override
    public Optional<CardPackageModel> findById(Integer integer) {
        return cardPackageRepository.findById(integer);
    }
}
