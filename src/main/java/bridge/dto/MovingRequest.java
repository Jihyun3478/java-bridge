package bridge.dto;

import static bridge.constant.BridgeConstant.*;
import static bridge.exception.ExceptionMessage.*;

import java.util.Objects;

public class MovingRequest {
    private final boolean moving;

    public MovingRequest(boolean moving) {
        this.moving = moving;
    }

    // TODO : enum화해서 겹치는 로직 간소화하고 예외메시지 유연하게 만들기.
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
