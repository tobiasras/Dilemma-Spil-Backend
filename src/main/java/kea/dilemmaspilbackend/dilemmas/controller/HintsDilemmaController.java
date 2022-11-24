package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.service.HintsDilemmaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HintsDilemmaController {

    private HintsDilemmaService hintsDilemmaService;

    HintsDilemmaController(HintsDilemmaService hintsDilemmaService){
        this.hintsDilemmaService = hintsDilemmaService;
    }
}
