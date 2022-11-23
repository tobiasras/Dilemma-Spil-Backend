package kea.dilemmaspilbackend.dilemmas.service;

import kea.dilemmaspilbackend.dilemmas.model.CommentsDilemmaModel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CommentsDilemmaService implements CrudInterface<CommentsDilemmaModel, Integer> {
    @Override
    public Set<CommentsDilemmaModel> findAll() {
        return null;
    }

    @Override
    public CommentsDilemmaModel save(CommentsDilemmaModel object) {
        return null;
    }

    @Override
    public void delete(CommentsDilemmaModel object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Optional<CommentsDilemmaModel> findById(Integer integer) {
        return Optional.empty();
    }
}
