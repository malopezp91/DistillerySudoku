package com.distillery.challenge.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void isValid_sudokuIsNull_returnsFalse() {
        assertFalse(sudoku.isValidSudoku(null));
    }

    @Test
    public void isValid_sudokuHas8Rows_returnsFalse() {
        char[][] input = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '7', '.', '.', '.', '.', '6', '.'},
                new char[]{'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'}};
                // Only 8 rows

        assertFalse(sudoku.isValidSudoku(input));
    }

    @Test
    public void isValid_sudokuHas9RowsButOneWith8Elements_returnsFalse() {
        char[][] input = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '7', '.', '.', '.', '.', '6', '.'},
                new char[]{'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7'}}; // Invalid row, only 8 elements

        assertFalse(sudoku.isValidSudoku(input));
    }

    @Test
    public void isValid_sudokuHasRowWithRepeatedElements_returnsFalse() {
        char[][] input = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '8'}, // Invalid row, has two '8'
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '7', '.', '.', '.', '.', '6', '.'},
                new char[]{'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        assertFalse(sudoku.isValidSudoku(input));
    }

    @Test
    public void isValid_sudokuHasColumnWithRepeatedElements_returnsFalse() {
        char[][] input = new char[][]{
                // First column has two '3'
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'3', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '7', '.', '.', '.', '.', '6', '.'},
                new char[]{'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'3', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        assertFalse(sudoku.isValidSudoku(input));
    }

    @Test
    public void isValid_sudokuHasInvalidBox_returnsFalse() {
        char[][] input = new char[][]{
                // First Box has two '8'
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'3', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'2', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        assertFalse(sudoku.isValidSudoku(input));
    }

    @Test
    public void isValid_sudokuIsValidWithEmptyElements_returnsTrue() {
        char[][] input = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '7', '.', '.', '.', '.', '6', '.'},
                new char[]{'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        assertTrue(sudoku.isValidSudoku(input));
    }

    @Test
    public void isValid_sudokuIsValidWithFullBox_returnsTrue() {
        char[][] input = new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '1', '2', '3'},
                new char[]{'.', '.', '.', '.', '.', '.', '4', '5', '6'},
                new char[]{'.', '.', '.', '.', '.', '.', '7', '8', '9'}};

        assertTrue(sudoku.isValidSudoku(input));
    }

    @Test
    public void isValid_sudokuIsValidWithFullElements_returnsTrue() {
        char[][] input = new char[][]{
                new char[]{'1', '2', '3', '6', '7', '8', '9', '4', '5'},
                new char[]{'5', '8', '4', '2', '3', '9', '7', '6', '1'},
                new char[]{'9', '6', '7', '1', '4', '5', '3', '2', '8'},
                new char[]{'3', '7', '2', '4', '6', '1', '5', '8', '9'},
                new char[]{'6', '9', '1', '5', '8', '3', '2', '7', '4'},
                new char[]{'4', '5', '8', '7', '9', '2', '6', '1', '3'},
                new char[]{'8', '3', '6', '9', '2', '4', '1', '5', '7'},
                new char[]{'2', '1', '9', '8', '5', '7', '4', '3', '6'},
                new char[]{'7', '4', '5', '3', '1', '6', '8', '9', '2'}};

        assertTrue(sudoku.isValidSudoku(input));
    }
}
