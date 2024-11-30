package bridge.domain;

import static bridge.constant.BridgeConstant.*;
import static bridge.exception.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.List;

import bridge.util.BridgeNumberGenerator;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    // TODO : 리팩토링 하기
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generate = bridgeNumberGenerator.generate();
            if(generate == 0) {
                result.add(DOWN);
            }
            if(generate != 0) {
                result.add(UP);
            }
        }
        return result;
    }

    private void validateSize(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage(MINIMUM_BRIDGE_SIZE, MAXIMUM_BRIDGE_SIZE));
        }
    }
}
