package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.service.DilemmaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DilemmaController {

    private DilemmaService dilemmaService;

    public DilemmaController(DilemmaService dilemmaService){
        this.dilemmaService = dilemmaService;
    }


}
