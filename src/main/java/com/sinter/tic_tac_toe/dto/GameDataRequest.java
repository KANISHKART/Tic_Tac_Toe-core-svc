package com.sinter.tic_tac_toe.dto;

import java.util.List;

import lombok.Data;

@Data
public class GameDataRequest {

    private List<String> gameData;

    private int currentPos;

}
