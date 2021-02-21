import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private final List<Frame> frames;

    public BowlingGame() {
        this.frames = new ArrayList<>();
    }

    public void addFrame(int roll0) {
        addFrame(roll0, 0);
    }

    public void addFrame(int roll0, int roll1) {
        frames.add(new Frame(roll0, roll1));
    }

    public void addFrame(int roll0, int roll1, int roll2) {
        frames.add(new LastFrame(roll0, roll1, roll2));
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame currentFrame = frames.get(i);
            score += currentFrame.getScore();
            if (currentFrame.isSpare()) {
                if (currentFrame.isNotLast()) {
                    Frame nextFrame = frames.get(i + 1);
                    score += nextFrame.getRoll0();
                }
            } else if (currentFrame.isStrike()) {
                if (currentFrame.isNotLast()) {
                    Frame nextFrame = frames.get(i + 1);
                    score += nextFrame.getScore();
                    if (nextFrame.isStrike() && nextFrame.isNotLast()) {
                        Frame nextNextFrame = frames.get(i + 2);
                        if (nextNextFrame.isNotLast()) {
                            score += nextNextFrame.getRoll0();
                        }
                    }
                }
            }
        }
        return score;
    }
}