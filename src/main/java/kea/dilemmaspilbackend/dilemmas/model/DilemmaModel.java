package kea.dilemmaspilbackend.dilemmas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class DilemmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String daDescription;
    private String enDescription;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private CardPackageModel cardPackageModel;

    @OneToMany(mappedBy = "dilemmaModelCP")
    private Set<CommentsDilemmaModel> commentsDilemmaModels = new HashSet<>();

    @OneToMany(mappedBy = "dilemmaModelGA")
    private Set<GameAnswersModel> gameAnswersModels = new HashSet<>();

    @OneToMany(mappedBy = "dilemmaModelHI")
    private Set<HintsDilemmaModel> hintsDilemmaModels = new HashSet<>();


}
