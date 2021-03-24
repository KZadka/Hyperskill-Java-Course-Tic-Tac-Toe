package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
}
