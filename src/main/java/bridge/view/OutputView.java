package bridge.view;

import static bridge.view.OutputMessage.*;

import bridge.dto.MapResponse;
import bridge.dto.ResultResponse;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String DELIMITER = " | ";

    public static void start() {
        print(START_GAME.getMessage());
    }

    public static void inputBridgeSize() {
        print(INPUT_BRIDGE_SIZE.getMessage());
    }

    public static void inputMoveDirection() {
        print(INPUT_MOVE_DIRECTION.getMessage());
    }

    public static void inputRetry() {
        print(INPUT_RETRY.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(MapResponse response) {
        print(OutputMessage.MAP.getMessage(String.join(DELIMITER, response.getUpBridge())));
        print(OutputMessage.MAP.getMessage(String.join(DELIMITER, response.getDownBridge())));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(ResultResponse result) {
        if(result.isSuccess()) {
            print(IS_SUCCESS.getMessage(SUCCESS.getMessage()));
            print(FINAL_TRY_COUNT.getMessage(result.getTryCount()));
            return;
        }
        print(IS_SUCCESS.getMessage(FAIL.getMessage()));
        print(FINAL_TRY_COUNT.getMessage(result.getTryCount()));
    }

    public static void printErrorMessage(Exception e) {
        print(e.getMessage());
    }

    public static void finalResult() {
        print(FINAL_RESULT.getMessage());
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
