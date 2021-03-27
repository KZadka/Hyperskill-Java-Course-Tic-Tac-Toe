package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String userInput = scanner.nextLine();
        Character[][] field = new Character[3][3];

        int counter = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = userInput.charAt(counter);
                counter++;
            }
        }
        lineOfDashes();
        System.out.println(firstLine(userInput));
        System.out.println(secondLine(userInput));
        System.out.println(thirdLine(userInput));
        lineOfDashes();
        int usersXi = 0;
        int usersXj = 0;
        while(true) {
            System.out.println("Enter the coordinates: ");
            String usersCoordinateI = scanner.next();
            String usersCoordinateJ = scanner.next();
            try {
                usersXi = Integer.parseInt(usersCoordinateI) - 1;
                usersXj = Integer.parseInt(usersCoordinateJ) - 1;
            } catch (NumberFormatException nfe) {
                System.out.println("You should enter numbers!");
            }


            if (field[usersXi][usersXj] == '_') {
                field[usersXi][usersXj] = 'X';
                gameGrid(field);
                break;
            } else if (!(field[usersXi][usersXj] == '_')) {
                System.out.println("This cell is occupied! Choose another one!");
            } else if (usersXi >= 3 || usersXi <= 0 || usersXj >= 3 || usersXj <= 0) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }

/*
        String result = "";
        boolean xWins = false;
        boolean oWins = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                if (field[0][0] + field[0][1] + field[0][2] == 264 ||//poziomy
                    field[1][0] + field[1][1] + field[1][2] == 264 ||//poziomy
                    field[2][0] + field[2][1] + field[2][2] == 264 ||//poziomy
                    field[0][0] + field[1][0] + field[2][0] == 264 ||//piony
                    field[0][1] + field[1][1] + field[2][1] == 264 ||//piony
                    field[0][2] + field[1][2] + field[2][2] == 264 ||//piony
                    field[0][0] + field[1][1] + field[2][2] == 264 ||//skosy
                    field[0][2] + field[1][1] + field[2][0] == 264) {//skosy
                    xWins = true;
                }
                if (field[0][0] + field[0][1] + field[0][2] == 237 ||//poziomy
                    field[1][0] + field[1][1] + field[1][2] == 237 ||//poziomy
                    field[2][0] + field[2][1] + field[2][2] == 237 ||//poziomy
                    field[0][0] + field[1][0] + field[2][0] == 237 ||//piony
                    field[0][1] + field[1][1] + field[2][1] == 237 ||//piony
                    field[0][2] + field[1][2] + field[2][2] == 237 ||//piony
                    field[0][0] + field[1][1] + field[2][2] == 237 ||//skosy \
                    field[0][2] + field[1][1] + field[2][0] == 237) {//skosy /
                    oWins = true;
                }
            }
        }
        if ((oWins && xWins) || differenceCount(field)) {
            result = "Impossible";
        } else if (oWins) {
            result = "O wins";
        } else if (xWins) {
            result = "X wins";
        } else if (!(xWins && oWins) && isFull(field)) {
            result = "Draw";
        } else if (!(xWins && oWins)) {
            result = "Game not finished";
        }
        System.out.println(result);
*/

    }
    private static void lineOfDashes() {
        System.out.println("---------");
    }
    private static String firstLine(String userInput){
        String firstText = userInput.substring(0, 3);
        return "| " + firstText.charAt(0) + " " + firstText.charAt(1) + " " + firstText.charAt(2)  + " |";
    }
    private static String secondLine(String userInput) {
        String secondText = userInput.substring(3, 6);
        return "| " + secondText.charAt(0) + " " + secondText.charAt(1) + " " + secondText.charAt(2)  + " |";
    }
    private static String thirdLine(String userInput) {
        String thirdText = userInput.substring(6, 9);
        return "| " + thirdText.charAt(0) + " " + thirdText.charAt(1) + " " + thirdText.charAt(2)  + " |";
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
    private static boolean differenceCount(Character[][] matrix) {
        int x = 0;
        int o = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'X')  {
                    x++;
                } else if (matrix[i][j] == 'O') {
                    o++;
                }
            }
        }
        if (Math.abs(x - o ) >= 2 || Math.abs(o - x) >= 2) {
            return true;
        } else {
            return false;
        }
    }
    private static void gameGrid(Character[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}


