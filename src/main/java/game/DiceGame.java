package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceGame {

    private static final String one =
            "-----\n" +
            "|   |\n" +
            "| * |\n" +
            "|   |\n" +
            "-----\n";

    private static final String two =
            "-----\n" +
            "|  *|\n" +
            "|   |\n" +
            "|*  |\n" +
            "-----\n";

    private static final String three =
            "-----\n" +
            "|  *|\n" +
            "| * |\n" +
            "|*  |\n" +
            "-----\n";

    private static final String four =
            "-----\n" +
            "|* *|\n" +
            "|   |\n" +
            "|* *|\n" +
            "-----\n";

    private static final String five =
            "-----\n" +
            "|* *|\n" +
            "| * |\n" +
            "|* *|\n" +
            "-----\n";

    private static final String six =
            "-----\n" +
            "|* *|\n" +
            "|* *|\n" +
            "|* *|\n" +
            "-----\n";


    private final static String WIN = "Great you won :)...!!";
    private final static String LOS = "I am sorry you lost :(...!!";
    private final static String TIE = "Not bad, its a tie...!!";

    private int numPlayer = 2;

    private int lastGameScoredBestIndex;

    private int[] scores;

    private List<List<Integer>> outcomes = new ArrayList<>(numPlayer);

    private Random rng = new Random();

    public DiceGame() {
        this(2);
    }

    private DiceGame(final int numPlayer) {
        this.numPlayer = numPlayer;
        this.scores = new int[numPlayer];
    }

    public List<List<Integer>> rollTheDice() {

        for (int i = 0; i < numPlayer; i++) {
            outcomes.add(i, drawDices());
            setScore(i, addDice(outcomes.get(i)));
        }
        return outcomes;
    }

    void checkTheWinner() {
        int maxScore = 0;
        for (int i = 0; i < numPlayer; i++) {
            if (addDice(outcomes.get(i)) > maxScore) {
                setLastGameScoredBestIndex(i);
                maxScore = addDice(outcomes.get(i));
            } else if (addDice(outcomes.get(i)) == maxScore)
                setLastGameScoredBestIndex(-1);
        }
    }

    void setOutcomes(List<List<Integer>> customOutcomes) {
        this.outcomes = customOutcomes;
    }

    void setLastGameScoredBestIndex(int bestIndex) {
        lastGameScoredBestIndex = bestIndex;
    }

    int getLastGameScoredBestIndex() {
        return lastGameScoredBestIndex;
    }

    public int addDice(List<Integer> diceList) {
        return diceList.get(0) + diceList.get(1);
    }

    public List<Integer> drawDices() {
        List<Integer> dicesList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            dicesList.add(rng.nextInt(6)+1);
        }

        return dicesList;
    }

    public static String getDiceString(final int diceValue) {
        switch (diceValue) {
            case 1:
                return DiceGame.one;
            case 2:
                return DiceGame.two;
            case 3:
                return DiceGame.three;
            case 4:
                return DiceGame.four;
            case 5:
                return DiceGame.five;
            case 6:
                return DiceGame.six;
        }
        throw new IllegalArgumentException("not a dice value");
    }

    static List<String> getDiceValueStrings(final List<Integer> diceList) {
        final List<String> diceStrings = new ArrayList<>(diceList.size());
        diceList.forEach(value -> diceStrings.add(getDiceString(value)));
        return diceStrings;
    }

    String printTheWinner() {

        if (getLastGameScoredBestIndex() == -1)
            return TIE;
        else if (getLastGameScoredBestIndex() == 0)
            return WIN;
        else
            return LOS;
    }

    void printDiceValues(List<Integer> dices) {
        for (String dice : DiceGame.getDiceValueStrings(dices)) {
            System.out.println(dice);
        }
    }

    public void setScore(int playerIndex, int score) {
        scores[playerIndex] = score;
    }

    int getScore(int playerIndex) {
        return scores[playerIndex];
    }
}