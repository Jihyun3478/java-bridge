package bridge;

public class Player {
    private final int position = 0;

    public Player() {
    }

    public void move(String input) {
        if (input.equals("U")) {
            return;
        }
        if (input.equals("D")) {
            return;
        }
        throw new IllegalArgumentException("");
    }
}
