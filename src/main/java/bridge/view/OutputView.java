package bridge.view;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import bridge.dto.MapResponse;
import bridge.dto.ResultResponse;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void start() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void inputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void inputMoveDirection() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void inputRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(MapResponse response) {
        String O = "O";
        String X = response.lastTryResult() ? " " : "X";

        System.out.print("[ ");
        List<String> resultUp = response.getBridge().stream().map(direction -> {
                if(Objects.equals(direction, "U")) {
                    return O;
                }
                return X;
            }
        ).collect(Collectors.toList());
        System.out.print(String.join(" | ", resultUp));
        System.out.println(" ]");

        System.out.print("[ ");

        List<String> resultDown = response.getBridge().stream().map(direction -> {
                if(Objects.equals(direction, "D")) {
                    return O;
                }
                return X;
            }
        ).collect(Collectors.toList());
        System.out.print(String.join(" | ", resultDown));
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(ResultResponse result) {
        System.out.println("게임 성공 여부: " + (result.isSuccess() ? "성공" : "실패"));
        System.out.println("총 시도한 횟수: " + result.getTryCount());
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage() + " 다시 입력해 주세요.");
    }

    public static void finalResult() {
        System.out.println("최종 게임 결과");
    }
}
