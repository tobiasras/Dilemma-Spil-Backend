package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.service.PersistGameLobbyService;
import kea.dilemmaspilbackend.game.model.RoundResponse;
import kea.dilemmaspilbackend.game.model.persistmodel.GameLobbyPersist;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class PersistGameLobbyController {
    private PersistGameLobbyService persistGameLobbyService;

    @GetMapping("/admin/get-finished-games")
    public ResponseEntity<List<GameLobbyPersist>> getAllFinishedGames() {
        return new ResponseEntity<>(persistGameLobbyService.getAllFinishedGames(), HttpStatus.OK);
    }
    @GetMapping("/admin/dilemma/{dilemmaID}/response/")
    public ResponseEntity<List<RoundResponse>> getResponseByDilemma(@PathVariable int dilemmaID) {
        return new ResponseEntity<>(persistGameLobbyService.getResponseByDilemma(dilemmaID), HttpStatus.OK);
    }
}
