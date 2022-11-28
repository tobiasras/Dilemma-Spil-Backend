package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.dilemmas.model.CommentsDilemmaModel;
import kea.dilemmaspilbackend.dilemmas.model.DilemmaModel;
import kea.dilemmaspilbackend.dilemmas.service.CardPackageService;
import kea.dilemmaspilbackend.dilemmas.service.DilemmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CardPackageController {

    private CardPackageService cardPackageService;
    private DilemmaService dilemmaService;

    CardPackageController(CardPackageService cardPackageService, DilemmaService dilemmaService){
        this.cardPackageService = cardPackageService;
        this.dilemmaService = dilemmaService;
    }

    @PostMapping("/api/post/create/cardpackage")
    public ResponseEntity<String> createCardpackage(@RequestBody CardPackageModel cardPackageModel){

        cardPackageService.save(cardPackageModel);

       return ResponseEntity.ok("Created new package");
    }

    @PostMapping("/api/post/delete/{id}/cardpackage")
    public ResponseEntity<String> deleteCardpackage(@PathVariable Integer id){

        cardPackageService.deleteById(id);

        return ResponseEntity.ok("Deleted package");
    }

    @PostMapping("/api/post/adddilemma/{dilemmaid}/{id}/cardpackage")
    public ResponseEntity<String> addDilemma(@PathVariable Integer dilemmaid, @PathVariable Integer id){

        Optional<CardPackageModel> checkModel = cardPackageService.findById(id);
        Optional<DilemmaModel> checkDilemma = dilemmaService.findById(dilemmaid);

        if(checkModel.isPresent() && checkDilemma.isPresent()){

            CardPackageModel cardPackageModel = cardPackageService.findById(id).get();
            DilemmaModel dilemmaModel = dilemmaService.findById(dilemmaid).get();

            cardPackageModel.addDilemma(dilemmaModel);

            cardPackageService.save(cardPackageModel);

            return ResponseEntity.ok("Dilemma added");
        }
        else{
            return ResponseEntity.ok("Could not add dilemma");
        }

    }


}
