package com.distillery.challenge.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Sudoku
 * Contains methods that validates a Sudoku array
 */
final class Sudoku {

    private static final int BOARD_SIZE = 9;
    private static final int BOX_SIZE = 3;

    public boolean isValidSudoku(char[][] board) {
        return Objects.nonNull(board) &&
                isValidSize(board) &&
                areRowsValid(board) &&
                areColumnsValid(board) &&
                areBoxesValid(board);
    }

    private boolean isValidSize(char[][] board) {
        // Number of rows must match BOARD_SIZE,
        // and all rows must contain BOARD_SIZE number of items
        if (board.length == BOARD_SIZE) {
            for (char[] row : board) {
                if (row.length != BOARD_SIZE) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean areRowsValid(char[][] board) {
        // All rows must contain not repeating digits. Using a Set ot perform this validation easily
        for (char[] row : board) {
            Set<Character> helperSet = new HashSet<>();
            for (char item : row) {
                if (Character.isDigit(item)) {
                    if (helperSet.contains(item)) {
                        return false;
                    } else {
                        helperSet.add(item);
                    }
                }
            }
        }
        return true;
    }

    private boolean areColumnsValid(char[][] board) {
        // All rows, at the same columnIndex, must contain not repeating digits.
        // Using a Set ot perform this validation easily
        for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
            Set<Character> helperSet = new HashSet<>();
            for (char[] row : board) {
                char item = row[columnIndex];
                if (Character.isDigit(item)) {
                    if (helperSet.contains(item)) {
                        return false;
                    } else {
                        helperSet.add(item);
                    }
                }
            }
        }
        return true;
    }

    private boolean areBoxesValid(char[][] board) {
        // For each box, a Set will be used to validate if there are non repeating digits.
        List<Set<Character>> helperList = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {

            // When we hit a row that is the first row of a box, Sets are rebooted
            if (rowIndex % BOX_SIZE == 0) {
                helperList.clear();
                int numOfBoxes = BOARD_SIZE / BOX_SIZE;
                for (int boxCounter = 0; boxCounter < numOfBoxes; boxCounter++) {
                    helperList.add(new HashSet<>());
                }
            }

            char[] row = board[rowIndex];
            for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
                int boxHelperSet = columnIndex / BOX_SIZE;
                Set<Character> helperSet = helperList.get(boxHelperSet);
                char item = row[columnIndex];
                if (Character.isDigit(item)) {
                    if (helperSet.contains(item)) {
                        return false;
                    } else {
                        helperSet.add(item);
                    }
                }
            }
        }
        return true;
    }
}
