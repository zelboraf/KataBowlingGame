import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {
    private BowlingGame game;

    @BeforeEach
    void setUp() {
        game = new BowlingGame();
    }

    @Test
    void shouldScoreZeroWhenNoPinsDown() {
        for (int i = 0; i < 10; i++) {
            game.addFrame(0, 0);
        }
        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    void shouldScore20When20rollsWithOnePinDown() {
        for (int i = 0; i < 10; i++) {
            game.addFrame(1, 1);
        }
        assertThat(game.getScore()).isEqualTo(20);
    }

    @Test
    void shouldScore90When10FramesWith9And0pinsDown() {
        for (int i = 0; i < 10; i++) {
            game.addFrame(9, 0);
        }
        assertThat(game.getScore()).isEqualTo(90);
    }

    @Test
    void shouldScore150When10FramesWithSpare() {
        for (int i = 0; i < 9; i++) {
            game.addFrame(5, 5);
        }
        game.addFrame(5, 5, 5);
        assertThat(game.getScore()).isEqualTo(150);
    }

    @Test
    void shouldScore300When12Strikes() {
        for (int i = 0; i < 9; i++) {
            game.addFrame(10, 0);
        }
        game.addFrame(10, 10, 10);
        assertThat(game.getScore()).isEqualTo(300);
    }
}