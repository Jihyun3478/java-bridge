package bridge.service;

import java.util.List;
import java.util.Objects;

import bridge.domain.BridgeMaker;
import bridge.domain.Player;
import bridge.dto.ResultResponse;
import bridge.util.BridgeRandomNumberGenerator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Player player = new Player();
    private List<String> bridge;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void setUp(int bridgeSize) {
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean isPlaying() {
        return !player.isFinish(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        return player.move(input, bridge);
    }

    public List<String> map() {
        return bridge;
    }

    public boolean isFinish(String input) {
        return Objects.equals(input, "Q");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retrySetUp() {
        player.setUp();
    }

    public ResultResponse result() {
        return ResultResponse.of(player, bridge);
    }
}
