package bridge.dto;

import java.util.Objects;

public class RestartRequest {
    private final boolean restart;

    public RestartRequest(boolean restart) {
        this.restart = restart;
    }

    // TODO : enum화해서 겹치는 로직 간소화하고 예외메시지 유연하게 만들기.
    public static RestartRequest from(String input) {
        if (Objects.equals(input, "Q")) {
            return new RestartRequest(true);
        }
        if (Objects.equals(input, "R")) {
            return new RestartRequest(false);
        }
        throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해야 합니다.");
    }

    public boolean getRestart() {
        return restart;
    }
}