package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character[][] field = new Character[3][3];


       emptyGrid(field);
        char playerChar = 'X';

        String result = "";
        do {
            int usersXi = 0;
            int usersXj = 0;
            System.out.println("Enter the coordinates: ");
            String usersCoordinateI = scanner.next();
            String usersCoordinateJ = scanner.next();
            try {
                usersXi = Integer.parseInt(usersCoordinateI) - 1;
                usersXj = Integer.parseInt(usersCoordinateJ) - 1;
            } catch (NumberFormatException nfe) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (usersXi >= 0 && usersXj >= 0) {
                if (usersXi < 0 || usersXj >= 3 || usersXj < 0 || usersXi >= 3) {
                    System.out.println("Coordinates should be from 1 to 3!");

                } else if (field[usersXi][usersXj] == '_') {
                    field[usersXi][usersXj] = playerChar;
                    gameGrid(field);

                } else if (!(field[usersXi][usersXj] == '_')) {
                    System.out.println("This cell is occupied! Choose another one!");
                }
                if (playerChar == 'X') {
                    playerChar = 'O';
                } else {
                    playerChar = 'X';
                }
            }

            if (whoWins(field) == 'O') {
                result = "O wins";
            } else if (whoWins(field) == 'X') {
                result = "X wins";
            } else if (whoWins(field) == ' ' && isFull(field)) {
                result = "Draw";
            }
            System.out.println(result);

        } while (result.equals(""));
    }
    // Methods
        private static void lineOfDashes() {
        System.out.println("---------");
    }
    private static Boolean isFull(Character[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }
    private static void gameGrid(Character[][] field) {
        lineOfDashes();
        for (int i = 0; i < field.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        lineOfDashes();
    }
    private static char whoWins(Character[][] field) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                return  field[i][0];
            }
        }
        for (int j = 0; j < field.length; j++ ) {
            if (field[0][j] == field[1][j] && field[1][j] == field[2][j]) {
                return field[0][j];
            }
        }
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            return field[0][0];
        }
        if (field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
            return field[0][2];
        }
        return ' ';
    }
    private static void emptyGrid(Character[][] field) {
        lineOfDashes();
        for (int i = 0; i < field.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = '_';
                System.out.print(field[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        lineOfDashes();
    }
}


