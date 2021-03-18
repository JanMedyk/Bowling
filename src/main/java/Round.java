import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Scanner;

/**The Round class stores data such as the number of points scored in each throw.
 * The firstThrow variable holds the number of points scored in the first throw, the secondThrow variable stores the number of points scored in the second throw.
 * The ptsSummaryInRound variable sums the number of points scored in this round.
 * Spare and Strrike variables store information whether Spare and Strike were obtained in the round (true or false), which will allow you to score additional points in the next round.

 Maximum number of points to be scored in a round: 10
 Throw for 10 in 1 throw: Strike - Double the value of two consecutive throws
 Throw for 10 in 2 throws: Spare - double the value of the next throw
 Max number of points to be scored in the game: 300
 **/
@Getter
@Setter
public class Round {
    private int firstThrow;
    private int secondThrow;
    private int pktSummaryInRound;

    private Boolean Spare;
    private Boolean Strike;

    public Round(int firstThrow, int secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        if (firstThrow + secondThrow == 10 && secondThrow != 0) {
            this.Spare = true;
            this.Strike = false;

        } else if (firstThrow == 10) {
            this.secondThrow = 0;
            this.Strike = true;
            this.Spare = false;
        } else {
            this.Strike = false;
            this.Spare = false;
        }
        this.pktSummaryInRound = firstThrow + secondThrow;

    }



}
