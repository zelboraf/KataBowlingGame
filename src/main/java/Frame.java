public class Frame {
    private final int roll0;
    private final int roll1;

    public Frame(int roll0, int roll1) {
        this.roll0 = roll0;
        this.roll1 = roll1;
    }

    public int getScore() {
        return roll0 + roll1;
    }

    public int getRoll0() {
        return roll0;
    }

    public boolean isStrike() {
        return roll0 == 10;
    }

    public boolean isSpare() {
        return (roll0 + roll1 == 10) && (roll0 < 10);
    }

    public boolean isNotLast() {
        return !(this instanceof LastFrame);
    }
}
