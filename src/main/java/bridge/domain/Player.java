package bridge.domain;

import static bridge.constant.BridgeConstant.*;

import java.util.List;
import java.util.Objects;

public class Player {
    private static final int DEFAULT_POSITION = 0;
    private int position = DEFAULT_POSITION;
    private boolean lastTryResult;

    public Player() {
    }

    public Player(int position) {
        this.position = position;
    }

    public boolean move(boolean moving, List<String> bridge) {
        if (moving) {
            boolean resultUp = Objects.equals(bridge.get(position), UP);
            if (resultUp) {
                position++;
            }
            lastTryResult = resultUp;
            return lastTryResult;
        }
        boolean resultDown = Objects.equals(bridge.get(position), DOWN);
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
        position = DEFAULT_POSITION;
    }
}
