package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Player {
    private int position = 0;
    private boolean lastTryResult;

    public Player() {
    }

    public Player(int position) {
        this.position = position;
    }

    public boolean move(boolean moving, List<String> bridge) {
        if (moving) {
            boolean resultUp = Objects.equals(bridge.get(position), "U");
            if (resultUp) {
                position++;
            }
            lastTryResult = resultUp;
            return lastTryResult;
        }
        boolean resultDown = Objects.equals(bridge.get(position), "D");
        if (resultDown) {
            position++;
        }
        lastTryResult = resultDown;
        return lastTryResult;
    }

    public int getPosition() {
        return position;
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
