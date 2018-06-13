package game;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DiceGameConsole {

    public static void main(String args[]) throws IOException {
        final DiceGame diceGame = new DiceGame();

        System.out.println("A small dice game!");
        int n;
        do {
            System.out.println("1. Play");
            System.out.println("0. Exit");
            System.out.print("input: ");
            Scanner input = new Scanner(System.in);
            n = input.nextInt();

            switch (n) {
                case 0:
                    break;
                case 1:
                    List<List<Integer>> outcomes = diceGame.rollTheDice();
                    System.out.printf("\n");
                    System.out.println("You rolled:");
                    System.out.printf("\n");
                    diceGame.printDiceValues(outcomes.get(0));
                    System.out.println("Your score is: " + diceGame.getScore(0));
                    System.out.printf("\n");
                    System.out.println("PC's turn...");
                    System.out.printf("\n");
                    System.out.println("PC rolled:");
                    System.out.printf("\n");
                    diceGame.printDiceValues(outcomes.get(1));
                    System.out.println("Computer's score: " + diceGame.getScore(1));
                    System.out.println("\n");
                    diceGame.checkTheWinner();
                    System.out.println(diceGame.printTheWinner());
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("\n");
                    System.out.println("Please enter either 1 or 0 ..!");
                    System.out.println("\n");
                    break;
            }

        } while (n != 0);

        System.out.println("\n");
        System.out.println("Bye bye!");
    }
}