import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GameTest {
    private Game game = new Game();

    @Test
    public void CanCountingPoints() {

        Game game = new Game();

        for (int i = 0; i <= 9; i++) {
            game.roll(new Round(1, 1), i);
        }
        assertThat(game.getPktSummary(), is(20));

    }

    @Test
    public void CanGetFullPoints() {

        Game game = new Game();
        String pointsForFirstExtraThrow = "10 10";

        InputStream in = new ByteArrayInputStream(pointsForFirstExtraThrow.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);


        for (int i = 0; i <= 9; i++) {
            game.roll(new Round(10, 0), i);
        }
        assertThat(game.getPktSummary(), is(300));

    }

    @Test
    public void canScoreWithSpareBonus() {
        String pointsForExtraThrow = "1";
        InputStream in = new ByteArrayInputStream(pointsForExtraThrow.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        for (int i = 0; i <= 9; i++) {
            game.roll(new Round(1, 9), i);
        }
        assertThat(game.getPktSummary(), is(110));
    }

    @Test
    public void canScoreWithStrikeBonus() {
        String pointsForExtraThrow = "10";
        InputStream in = new ByteArrayInputStream(pointsForExtraThrow.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        for (int i = 0; i <= 9; i++) {
            if (i == 5) {
                game.roll(new Round(10, 0), i);
            } else
                game.roll(new Round(1, 1), i);
        }
        assertThat(game.getPktSummary(), is(30));
    }

}