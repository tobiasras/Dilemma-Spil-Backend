package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.service.GameAnswersService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameAnswersController {

    private GameAnswersService gameAnswersService;

    GameAnswersController(GameAnswersService gameAnswersService){
        this.gameAnswersService = gameAnswersService;
    }
}
