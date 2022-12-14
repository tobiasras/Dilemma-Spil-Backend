package kea.dilemmaspilbackend.game.purger;


import kea.dilemmaspilbackend.game.model.GameLobby;
import kea.dilemmaspilbackend.game.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.*;


@AllArgsConstructor
@Component
public class GameLobbyPurger {

    // 10800000 = 3 Hours total lenght lobby canbe
    private final long MS_LIMIT = 10800000;

    GameService gameService;

    // 43200000 = 12 Hours
    @Scheduled(fixedRate = 43200000)
    public void purgeDeadLobbies(){

        System.out.println("Purging dead lobbies");

        Date now = Date.from(Instant.now());
        ArrayList<GameLobby> toBeDeleted = new ArrayList<>();

        List<GameLobby> allLobby = gameService.getAllLobby();

        for (GameLobby gameLobby : allLobby) {
            if(isTooOld(gameLobby.getTimeCreated(), now)){
                toBeDeleted.add(gameLobby);
            }
        }

        System.out.println("total Lobby purged : " + toBeDeleted.size());

        for (GameLobby gameLobby : toBeDeleted){
            gameService.removeGameLobby(gameLobby.getLobbyCode());
        }

    }

    private boolean isTooOld(Date now, Date lobby){
        long msBetween = now.getTime() - lobby.getTime();
        return msBetween > MS_LIMIT;
    }



}
