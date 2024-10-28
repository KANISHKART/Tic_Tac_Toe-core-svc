package com.sinter.tic_tac_toe.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sinter.tic_tac_toe.dto.GameDataRequest;

@Component
public class GameDataVerification {

    public static final Map<Integer, int[]> posDict = new HashMap<Integer, int[]>();

    static {
        posDict.put(1, new int[]{0, 0});
        posDict.put(2, new int[]{0, 1});
        posDict.put(3, new int[]{0, 2});
        posDict.put(4, new int[]{1, 0});
        posDict.put(5, new int[]{1, 1});
        posDict.put(6, new int[]{1, 2});
        posDict.put(7, new int[]{2, 0});
        posDict.put(8, new int[]{2, 1});
        posDict.put(9, new int[]{2, 2});
    }

    public boolean checkWinner(GameDataRequest request) {

        String arr[][] = new String[3][3];

        int row = posDict.get(request.getCurrentPos())[0];
        int column = posDict.get(request.getCurrentPos())[1];

        for (int i = 0, pos = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = request.getGameData().get(pos);
                pos++;
            }
        }

        if (row == 1 && column == 1) {
            if (arr[0][2].equals(arr[row][column]) && arr[1][2].equals(arr[row][column])) {
                return true;
            } else if (arr[2][0].equals(arr[row][column]) && arr[2][1].equals(arr[row][column])) {
                return true;
            } else if (arr[0][0].equals(arr[row][column]) && arr[2][2].equals(arr[row][column])) {
                return true;
            } else if (arr[0][2].equals(arr[row][column]) && arr[2][0].equals(arr[row][column])) {
                return true;
            }
        } else {
            if (arr[0][0].equals(arr[row][column]) && arr[1][1].equals(arr[row][column])
                    && arr[2][2].equals(arr[row][column])) {
                return true;
            } else if (arr[0][2].equals(arr[row][column]) && arr[1][1].equals(arr[row][column])
                    && arr[2][1].equals(arr[row][column])) {
                return true;
            } else if (arr[0][column].equals(arr[row][column]) && arr[1][column].equals(arr[row][column])
                    && arr[2][column].equals(arr[row][column])) {
                return true;
            } else if (arr[row][0].equals(arr[row][column]) && arr[row][1].equals(arr[row][column])
                    && arr[row][2].equals(arr[row][column])) {
                return true;
            }
        }

        return false;

    }
}
