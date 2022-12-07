package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.dilemmas.model.CommentsDilemmaModel;
import kea.dilemmaspilbackend.dilemmas.model.DilemmaModel;
import kea.dilemmaspilbackend.dilemmas.repository.DilemmaRepository;
import kea.dilemmaspilbackend.dilemmas.service.CardPackageService;
import kea.dilemmaspilbackend.dilemmas.service.DilemmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

            if(cardPackageModel.getDilemmaModels().size() > 0) {

                Set<DilemmaModel> models = cardPackageModel.getDilemmaModels();

                models.add(dilemmaModel);

                cardPackageModel.setDilemmaModels(models);
            }
            else{

                cardPackageModel.addDilemma(dilemmaModel);
            }

            cardPackageService.save(cardPackageModel);

            return ResponseEntity.ok("Dilemma added");
        }
        else{
            return ResponseEntity.ok("Could not add dilemma");
        }
    }

    @GetMapping("/api/get/find/{id}/cardpackage")
    public ResponseEntity<CardPackageModel> findCardPackage(@PathVariable() Integer id){

        Optional<CardPackageModel> checkCardPackageModel = cardPackageService.findById(id);

        if(checkCardPackageModel.isPresent()){
            CardPackageModel cardPackageModel = cardPackageService.findById(id).get();

            return ResponseEntity.ok(cardPackageModel);
        }
        else{
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/api/get/findall/cardpackage")
    public ResponseEntity<Set<CardPackageModel>> getAllCardpackages(){

        Set<CardPackageModel> set = new HashSet<>();

        cardPackageService.findAll().forEach(set::add);

        return ResponseEntity.ok(set);
    }

    @GetMapping("/api/get/alldilemmas/{id}/cardpackage")
    public ResponseEntity<List<DilemmaModel>> allDilemmasFromCardPackage(@PathVariable Integer id){

        Optional<CardPackageModel> checkCardPackageModel = cardPackageService.findById(id);

        if(checkCardPackageModel.isPresent()){

            List<DilemmaModel> dilemmaModels;

            dilemmaModels = cardPackageService.findDilemmasByCardPackageId(id);

            System.out.println(dilemmaModels.size());

            return ResponseEntity.ok(dilemmaModels);
        }
        else{
            return ResponseEntity.ok(null);
        }
    }

}
