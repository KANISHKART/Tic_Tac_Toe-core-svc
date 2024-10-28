package com.sinter.tic_tac_toe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinter.tic_tac_toe.dto.GameDataRequest;
import com.sinter.tic_tac_toe.utils.GameDataVerification;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class GameController {

    private final GameDataVerification gameVerificationData;

    public GameController(GameDataVerification gameVerificationData) {
        this.gameVerificationData = gameVerificationData;
    }

    @PostMapping(value = "/checkWinner", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> isWinner(@RequestBody GameDataRequest request) {

        return new ResponseEntity<>(gameVerificationData.checkWinner(request), HttpStatus.OK);
    }
}
