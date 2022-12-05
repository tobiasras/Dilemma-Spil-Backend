package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.GameLobbyStat;
import kea.dilemmaspilbackend.admin.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
public class StatisticsController {
    private StatisticsService statisticsService;

    @GetMapping("/admin/get-gamelobbystats")
    public ResponseEntity<List<GameLobbyStat>> getAllGameLobbies() {
        return new ResponseEntity<>(statisticsService.getAllGameLobbies(), HttpStatus.OK);
    }
}