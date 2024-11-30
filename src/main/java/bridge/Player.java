package bridge;

import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;

public class Player {
    private int position = 0;

    public Player() {
    }

    // 0:Down, 1:Up
    public boolean move(String input, List<String> bridge) {
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
}
