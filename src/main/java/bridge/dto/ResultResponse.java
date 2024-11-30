package bridge.dto;

import bridge.domain.Bridge;
import bridge.domain.Player;

public class ResultResponse {

    private final boolean isSuccess;
    private final int tryCount;

    public ResultResponse(boolean isSuccess, int tryCount) {
        this.isSuccess = isSuccess;
        this.tryCount = tryCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }

    public static ResultResponse of(Player player, Bridge bridge, int retryCount) {
        return new ResultResponse(player.isFinish(bridge), retryCount);
    }
}
