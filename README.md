# Distillery Sudoku Challenge

## Overview
This project implements the ***boolean isValidSudoku(char[][] board)*** method.
Current implementation considers:
- Board size is 9x9
- Has 9 boxes of 3x3
- It may contain empty spaces, represented by '.'

A sudoku is valid if:
- Input board has 9 rows and 9 columns, each one with 9 items each
- All digits in a row are unique
- All digits in a column are unique
- All digits in a box are unique

## Development
- The method implementation is based on  the chaining of each each validation.
- The complexity of this solution is O(N^2)
- Validations rely on helper Sets, which allow to validate if digit is present with a cost of O(1)

## Testing
Unit Tests can be executed in the IDE of your preference or via:

``` bash
mvn clean test
```

The SudokuTest class contains different tests methods that cover the following scenarios:
- Input is null
- Input board has only 8 columns
- Input board has one row with 9 elements
- Input board has a repeated digit in a row
- Input board has a repeated digit in a column
- Input board has a box with a repeated element
- Input, with some empty elements, has all valid digits
- Input, with only elements in a box, are valid
- Input has no empty elements and all digits are valid
