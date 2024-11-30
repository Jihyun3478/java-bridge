package bridge.dto;

import static bridge.exception.ExceptionMessage.*;

public class BridgeSizeRequest {
    private final int bridgeSize;

    public BridgeSizeRequest(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public static BridgeSizeRequest from(String input) {
        try {
            return new BridgeSizeRequest(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMessage());
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
