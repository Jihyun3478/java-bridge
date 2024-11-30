package bridge.domain;

import static bridge.constant.BridgeConstant.*;

public class Player {
    private static final int DEFAULT_POSITION = 0;
    private int position = DEFAULT_POSITION;
    private boolean lastTryResult;

    public Player() {
    }

    public Player(int position) {
        this.position = position;
    }

    public boolean move(boolean moving, Bridge bridge) {
        if (moving) {
            boolean resultUp = bridge.equalsTo(position, UP);
            if (resultUp) {
                position++;
            }
            lastTryResult = resultUp;
            return lastTryResult;
        }
        boolean resultDown = bridge.equalsTo(position, DOWN);
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

    public boolean isFinish(Bridge bridge) {
        return position == bridge.getSize();
    }

    public void setUp() {
        position = DEFAULT_POSITION;
    }
}
