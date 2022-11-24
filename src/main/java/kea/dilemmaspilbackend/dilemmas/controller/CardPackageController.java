package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.service.CardPackageService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardPackageController {

    private CardPackageService cardPackageService;

    CardPackageController(CardPackageService cardPackageService){
        this.cardPackageService = cardPackageService;
    }
}
