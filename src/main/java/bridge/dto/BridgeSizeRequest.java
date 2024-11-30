package bridge.dto;

import camp.nextstep.edu.missionutils.Console;

public class BridgeSizeRequest {
    private final int bridgeSize;

    public BridgeSizeRequest(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public static BridgeSizeRequest from(String input) {
        try {
            return new BridgeSizeRequest(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
