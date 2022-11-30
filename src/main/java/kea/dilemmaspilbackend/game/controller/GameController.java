package kea.dilemmaspilbackend.game.controller;
import kea.dilemmaspilbackend.game.model.GameLobby;
import kea.dilemmaspilbackend.game.model.Player;
import kea.dilemmaspilbackend.game.response.LobbyResponse;
import kea.dilemmaspilbackend.game.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Lob;


@AllArgsConstructor
@Controller
class GameController {

    private GameService gameService;

    @MessageExceptionHandler
    @SendTo("/topic/errors")
    public String handleException(IllegalArgumentException e) {
        var message = ("an exception occurred! " + NestedExceptionUtils.getMostSpecificCause(e));
        System.out.println(message);
        return message;
    }

    @MessageMapping("/game/{lobby}")
    @SendTo("/topic/greetings/{lobby}")
    public LobbyResponse joinLobby(@DestinationVariable String lobby, Player player) throws Exception {
        // player is a json request


        LobbyResponse lobbyResponse = new LobbyResponse();

        gameService.addPlayerToLobby(lobby, player);

        GameLobby gameLobby = gameService.fetchGameLobbyFromLobbyCode(lobby);

        lobbyResponse.setGameLobby(gameLobby);

        lobbyResponse.setMessage("joined Lobby: " + lobby + " added player name " + player.getName());

        return lobbyResponse;
    }


    @MessageMapping("/game/create/{lobby}")
    @SendTo("/topic/greetings/{lobby}")
    public LobbyResponse createLobby(@DestinationVariable String lobby) throws Exception {

        LobbyResponse lobbyResponse = new LobbyResponse();

        System.out.println(lobby);

        GameLobby gameLobby = gameService.fetchGameLobbyFromLobbyCode(lobby);

        System.out.println(gameLobby);

        lobbyResponse.setGameLobby(gameLobby);

        lobbyResponse.setMessage("Created lobby: " + lobby);

        System.out.println(lobbyResponse.getGameLobby());

        return lobbyResponse;
    }


}