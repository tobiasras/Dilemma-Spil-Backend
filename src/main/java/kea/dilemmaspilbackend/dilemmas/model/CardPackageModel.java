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

    private String daName;
    private String enName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE})
    @JoinTable(name = "dilemma_model_card_package_model",
            joinColumns = @JoinColumn(name = "card_package_model_id"),
            inverseJoinColumns = @JoinColumn(name = "dilemma_model_id"))
    private Set<DilemmaModel> dilemmaModels = new HashSet<>();

    public void addDilemma(DilemmaModel dilemmaModel){
        this.dilemmaModels.add(dilemmaModel);
    }
}
