package bridge.view;

import static bridge.view.OutputMessage.*;

import bridge.dto.MapResponse;
import bridge.dto.ResultResponse;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void start() {
        System.out.println(START_GAME.getMessage());
    }

    public static void inputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE.getMessage());
    }

    public static void inputMoveDirection() {
        System.out.println(INPUT_MOVE_DIRECTION.getMessage());
    }

    public static void inputRetry() {
        System.out.println(INPUT_RETRY.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(MapResponse response) {
        System.out.println(OutputMessage.MAP.getMessage(String.join(" | ", response.getUpBridge())));
        System.out.println(OutputMessage.MAP.getMessage(String.join(" | ", response.getDownBridge())));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(ResultResponse result) {
        if(result.isSuccess()) {
            System.out.println(IS_SUCCESS.getMessage(SUCCESS.getMessage()));
            System.out.println(FINAL_TRY_COUNT.getMessage(result.getTryCount()));
            return;
        }
        System.out.println(IS_SUCCESS.getMessage(FAIL.getMessage()));
        System.out.println(FINAL_TRY_COUNT.getMessage(result.getTryCount()));
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void finalResult() {
        System.out.println(FINAL_RESULT.getMessage());
    }
}
