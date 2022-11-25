package kea.dilemmaspilbackend.dilemmas.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class DilemmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String daName;
    private String enName;
    private String daDescription;
    private String enDescription;

    @OneToMany(mappedBy = "dilemmaModelCP")
    private Set<CommentsDilemmaModel> commentsDilemmaModels = new HashSet<>();

    @OneToMany(mappedBy = "dilemmaModelGA")
    private Set<GameAnswersModel> gameAnswersModels = new HashSet<>();

    @OneToMany(mappedBy = "dilemmaModelHI")
    private Set<HintsDilemmaModel> hintsDilemmaModels = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dilemma_model_card_package_model",
                joinColumns = @JoinColumn(name = "dilemma_model_id"),
                inverseJoinColumns = @JoinColumn(name = "card_package_model_id"))
    private Set<CardPackageModel> cardPackageModels = new HashSet<>();


    public void addComment(CommentsDilemmaModel commentsDilemmaModel){
                this.commentsDilemmaModels.add(commentsDilemmaModel);
    }
}


