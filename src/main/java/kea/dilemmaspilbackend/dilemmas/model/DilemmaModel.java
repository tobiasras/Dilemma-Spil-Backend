package kea.dilemmaspilbackend.dilemmas.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DilemmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
