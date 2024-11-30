package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Player {
    private int position = 0;
    private int tryCount = 0;

    public Player() {
    }

    public Player(int position) {
        this.position = position;
    }

    // 0:Down, 1:Up
    public boolean move(String input, List<String> bridge) {
        tryCount++;
        if (input.equals("U")) {
            if (Objects.equals(bridge.get(position), "U")) {
                position++;
            }
            return Objects.equals(bridge.get(position), "U");
        }
        if (input.equals("D")) {
            if (Objects.equals(bridge.get(position), "D")) {
                position++;
            }
            return Objects.equals(bridge.get(position), "D");
        }
        throw new IllegalArgumentException();
    }

    public int getPosition() {
        return position;
    }

    public boolean isFinish(List<String> bridge) {
        return position == bridge.size();
    }

    public void setUp() {
        position = 0;
    }

    public int getTryCount() {
        return tryCount;
    }
}
