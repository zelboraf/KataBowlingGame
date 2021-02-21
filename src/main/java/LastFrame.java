public class LastFrame extends Frame {
    private final int roll2;

    public LastFrame(int roll0, int roll1, int roll2) {
        super(roll0, roll1);
        this.roll2 = roll2;
    }

    @Override
    public int getScore() {
        return super.getScore() + roll2;
    }
}
