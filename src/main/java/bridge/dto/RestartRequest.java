package bridge.dto;

import static bridge.constant.BridgeConstant.*;
import static bridge.exception.ExceptionMessage.*;

import java.util.Objects;

public class RestartRequest {
    private final boolean restart;

    public RestartRequest(boolean restart) {
        this.restart = restart;
    }

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
