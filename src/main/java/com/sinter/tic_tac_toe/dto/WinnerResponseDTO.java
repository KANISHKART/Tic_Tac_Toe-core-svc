package com.sinter.tic_tac_toe.dto;

import com.sinter.tic_tac_toe.enums.GameConstants;

import lombok.Data;

@Data
public class WinnerResponseDTO {

    private boolean isWinner;

    private GameConstants constants;

}
