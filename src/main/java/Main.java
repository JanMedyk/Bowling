import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Game game = new Game();
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < 10; i++) {
            int secondThrow = 0;
            int firstThrow;
            do {

                int round = i + 1;
                System.out.println("Round " + round + "\n");
                firstThrow = firstThrow(scanner);
                if (firstThrow != 10) {
                    secondThrow = secondThrow(scanner);

                }
                if (firstThrow > 10 || secondThrow > 10 || firstThrow < 0 || secondThrow < 0 || firstThrow + secondThrow > 10 || firstThrow + secondThrow < 0) {
                    System.out.println("Enter correct results");
                }

            } while (firstThrow > 10 || secondThrow > 10 || firstThrow < 0 || secondThrow < 0 || firstThrow + secondThrow > 10 || firstThrow + secondThrow < 0);

            game.roll(new Round(firstThrow, secondThrow), i);

            showPoints(game, i);

        }
        scanner.close();


    }

    /**
     * The firstThrow method is used to save the data in the first throw.
     * The method also checks if the user has not entered wrong values (e.g. Strings) into a variable which only accepts int.
     **/
    public static int firstThrow(Scanner scanner) {
        int firstThrow;
        System.out.println("Throw 1");
        do {
            try {

                firstThrow = scanner.nextInt();
                break;

            } catch (InputMismatchException e) {
                System.out.println("This isn't number");
                System.out.println("Throw 1");
                scanner.nextLine();

            }
        } while (true);
        return firstThrow;
    }

    /**
     * The secondThrow method is used to save the data in the first throw.
     * The method also checks if the user has not entered wrong values (e.g. Strings) into a variable which only accepts int.
     **/
    public static int secondThrow(Scanner scanner) {
        int secondThrow;
        System.out.println("Throw 2");
        do {


            try {
                secondThrow = scanner.nextInt();
                break;

            } catch (InputMismatchException e) {
                System.out.println("This isn't number");
                System.out.println("Throw 2");
                scanner.nextLine();
            }
        } while (true);
        return secondThrow;
    }

    /**
     * The showPoints method is used to display the current status on the scoreboard
     **/

    public static void showPoints(Game game, int i) {

        String template = "%20s";
        System.out.print("First Throw    :");
        game.rounds.forEach(e -> System.out.printf(template, e.getFirstThrow() + ""));
        System.out.println("\n");
        System.out.print("Second Throw   :");
        game.rounds.stream().forEach(e -> System.out.printf(template, e.getSecondThrow() + ""));
        System.out.println("\n");
        System.out.printf("BONUS          :");
        game.rounds.forEach(e ->
                {
                    if (e.getSpare() == true) {
                        System.out.printf(template, "SPARE");
                    }

                    if (e.getStrike() == true) {
                        System.out.printf(template, "STRIKE!");
                    } else {
                        System.out.printf(template, "");
                    }


                }

        );
        System.out.println("\n");
        System.out.print("Score          :" + game.getPktSummary());
        System.out.println("\n");

    }
}