package kea.dilemmaspilbackend.game.controller;


import kea.dilemmaspilbackend.game.model.GameLobby;
import kea.dilemmaspilbackend.game.model.Player;
import kea.dilemmaspilbackend.game.repository.GameRepository;
import kea.dilemmaspilbackend.game.response.LobbyResponse;
import kea.dilemmaspilbackend.game.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@AllArgsConstructor
@RestController
public class LobbyController {

    private GameService gameService;

    @PostMapping ("api/post/create/lobby")
    public ResponseEntity<GameLobby> createLobby(@RequestBody Player player){
        GameLobby gameLobby = gameService.createGameLobby(player);

        return new ResponseEntity<>(gameLobby, HttpStatus.OK);
    }


    @GetMapping("api/get/read/lobbyExist/{lobbyID}")
    public ResponseEntity<LobbyResponse> lobbyExist(@PathVariable String lobbyID){
        ResponseEntity<LobbyResponse> message;
        LobbyResponse lobbyResponse = new LobbyResponse();

        // finds game lobby
        GameLobby gameLobby = gameService.fetchGameLobbyFromLobbyCode(lobbyID);

        if (gameLobby != null){
            lobbyResponse.setGameLobby(gameLobby);
            lobbyResponse.setMessage("Lobby: Found");

            message = new ResponseEntity<>(lobbyResponse, HttpStatus.OK);
        } else {
            lobbyResponse.setGameLobby(null);
            lobbyResponse.setMessage("Lobby: Not Found");

            message = new ResponseEntity<>(lobbyResponse, HttpStatus.OK);
        }

        return message;
    }


    @GetMapping("api/get/all/lobby")
    public ResponseEntity<List<GameLobby>> getAllLobby(){
        List<GameLobby> list = gameService.getAllLobby();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }





}
