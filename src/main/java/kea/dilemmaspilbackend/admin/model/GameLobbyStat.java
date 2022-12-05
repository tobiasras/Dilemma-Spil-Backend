package kea.dilemmaspilbackend.admin.model;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.game.model.Player;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// This class stores all relevant, statistical information related to a game.
@Setter
@Getter
@Entity
public class GameLobbyStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_package_used_id")
    private CardPackageModel cardPackageUsed;
    @OneToMany
    private List<Player> playerList;
}
