package kea.dilemmaspilbackend.game.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Player {
    private String name;
    private String fieldOfStudy;
    private boolean isReady;
}
