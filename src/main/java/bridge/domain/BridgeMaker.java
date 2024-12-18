package bridge.domain;

import static bridge.constant.BridgeConstant.*;
import static bridge.exception.ExceptionMessage.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import bridge.util.BridgeNumberGenerator;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        return IntStream.range(0, size)
            .map(i -> bridgeNumberGenerator.generate())
            .boxed()
            .map(this::convertToString)
            .collect(Collectors.toList());
    }

    private void validateSize(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage(MINIMUM_BRIDGE_SIZE, MAXIMUM_BRIDGE_SIZE));
        }
    }

    private String convertToString(int bridgeNumber) {
        if (bridgeNumber == 0) {
            return DOWN;
        }
        return UP;
    }
}
