package com.distillery.challenge.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * SudokuTest
 * Validates isValid method from {@link Sudoku}
 */
final class SudokuTest {

    private Sudoku sudoku;

    @BeforeEach
    public void setup() {
        sudoku = new Sudoku();
    }

    @Test
    public void isValid_sudokIsNull_returnsFalse() {
        assertFalse(sudoku.isValidSudoku(null));
    }
}
