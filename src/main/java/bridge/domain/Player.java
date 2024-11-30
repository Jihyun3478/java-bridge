package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Player {
    private int position = 0;
    private int tryCount = 0;
    private boolean lastTryResult;

    public Player() {
    }

    public Player(int position) {
        this.position = position;
    }

    // 0:Down, 1:Up
    public boolean move(String input, List<String> bridge) {
        tryCount++;
        if (input.equals("U")) {
            boolean resultUp = Objects.equals(bridge.get(position), "U");
            if (resultUp) {
                position++;
            }
            lastTryResult = resultUp;
            return lastTryResult;
        }
        if (input.equals("D")) {
            boolean resultDown = Objects.equals(bridge.get(position), "D");
            if (resultDown) {
                position++;
            }
            lastTryResult = resultDown;
            return lastTryResult;
        }
        throw new IllegalArgumentException();
    }

    public int getPosition() {
        return position;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean lastTryResult() {
        return lastTryResult;
    }

    public boolean isFinish(List<String> bridge) {
        return position == bridge.size();
    }

    public void setUp() {
        position = 0;
    }
}
