package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.service.CommentsDilemmaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsDilemmaController {

    private CommentsDilemmaService commentsDilemmaService;

    CommentsDilemmaController(CommentsDilemmaService commentsDilemmaService){
        this.commentsDilemmaService = commentsDilemmaService;
    }



}
