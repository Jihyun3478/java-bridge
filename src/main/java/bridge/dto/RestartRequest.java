package bridge.dto;

import static bridge.constant.BridgeConstant.*;
import static bridge.exception.ExceptionMessage.*;

import java.util.Objects;

public class RestartRequest {
    private final boolean restart;

    public RestartRequest(boolean restart) {
        this.restart = restart;
    }

    // TODO : enum화해서 겹치는 로직 간소화하고 예외메시지 유연하게 만들기.
    public static RestartRequest from(String input) {
        if (Objects.equals(input, QUIT)) {
            return new RestartRequest(true);
        }
        if (Objects.equals(input, RESTART)) {
            return new RestartRequest(false);
        }
        throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage(RESTART, QUIT));
    }

    public boolean getRestart() {
        return restart;
    }
}
