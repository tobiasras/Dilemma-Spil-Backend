package kea.dilemmaspilbackend.dilemmas.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class CardPackageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "cardPackageModel")
    private Set<DilemmaModel> dilemmaModels = new HashSet<>();
}
