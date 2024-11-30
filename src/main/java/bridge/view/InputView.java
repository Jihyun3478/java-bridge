package bridge.view;

import bridge.dto.BridgeSizeRequest;
import bridge.dto.MovingRequest;
import bridge.dto.RestartRequest;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static BridgeSizeRequest readBridgeSize() {
        return BridgeSizeRequest.from(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static MovingRequest readMoving() {
        return MovingRequest.from(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static RestartRequest readGameCommand() {
        return RestartRequest.from(Console.readLine());
    }
}
