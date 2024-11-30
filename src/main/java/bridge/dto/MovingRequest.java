package bridge.dto;

import static bridge.constant.BridgeConstant.*;
import static bridge.exception.ExceptionMessage.*;

import java.util.Objects;

public class MovingRequest {
    private final boolean moving;

    public MovingRequest(boolean moving) {
        this.moving = moving;
    }

    public static MovingRequest from(String input) {
        if (Objects.equals(input, UP)) {
            return new MovingRequest(true);
        }
        if (Objects.equals(input, DOWN)) {
            return new MovingRequest(false);
        }
        throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage(UP, DOWN));
    }

    public boolean getMoving() {
        return moving;
    }
}
