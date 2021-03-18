import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**In the game class, we store all rounds in the rounds variable and the total number of points in the pointSummary.**/

public class Game {

    public ArrayList<Round> rounds = new ArrayList<>();
    public int pktSummary = 0;

    public Game() {
    }
/**The roll method is used to calculate the current number of points.
 * If a Strike or Spare was thrown in the previous round, additional points are awarded for these bonuses. **/
    public void roll(Round roundInGame, int i) {
        Scanner scanner = new Scanner(System.in);


        int bonus = 0;

        if (!this.rounds.isEmpty()) {


            if (this.rounds.get(this.rounds.size() - 1).getSpare().equals(Boolean.TRUE)) {
                this.rounds.get(this.rounds.size() - 1).setPktSummaryInRound(rounds.get(rounds.size() - 1).getPktSummaryInRound() + roundInGame.getFirstThrow());

                bonus = roundInGame.getFirstThrow();
            }
            if (rounds.get(rounds.size() - 1).getStrike().equals(Boolean.TRUE)) {
                if (roundInGame.getSecondThrow() == 0) {
                    rounds.get(rounds.size() - 1).setPktSummaryInRound(rounds.get(rounds.size() - 1).getPktSummaryInRound() + roundInGame.getFirstThrow() + roundInGame.getFirstThrow());
                    bonus = roundInGame.getFirstThrow() + roundInGame.getFirstThrow();
                } else {
                    rounds.get(rounds.size() - 1).setPktSummaryInRound(rounds.get(rounds.size() - 1).getPktSummaryInRound() + roundInGame.getFirstThrow() + roundInGame.getSecondThrow());
                    bonus = roundInGame.getFirstThrow() + roundInGame.getSecondThrow();
                }
            }
        }

        if (i == 9 && roundInGame.getStrike().equals(Boolean.TRUE)) {
            System.out.println("You have 2 extra throws\n");
            System.out.println("first extra throw");

            do {


                try {

                    bonus = bonus + scanner.nextInt();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("This isn't number");
                    System.out.println("first extra throw");
                    scanner.nextLine();


                }
            } while (true);

            System.out.println("second extra throw");
            do {


                try {

                    bonus = bonus + scanner.nextInt();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("This isn't number");
                    System.out.println("second extra throw");
                    scanner.nextLine();


                }
            } while (true);

            scanner.close();
        }
        if (i == 9 && roundInGame.getSpare().equals(Boolean.TRUE)) {
            System.out.println("You have 1 extra throw");
            System.out.println("your extra throw");
            do {


                try {

                    bonus = bonus + scanner.nextInt();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("This isn't number");
                    System.out.println(" extra throw");
                    scanner.nextLine();


                }
                scanner.close();
            } while (true);

        }
        this.rounds.add(roundInGame);
        setPktSummary(roundInGame.getPktSummaryInRound() + bonus);


    }


    public void setThrows(ArrayList<Round> aRounds) {
        this.rounds = aRounds;
    }


    public void setPktSummary(int pktSummary) {
        this.pktSummary = this.getPktSummary() + pktSummary;

    }

    public int getPktSummary() {
        return pktSummary;
    }


}
