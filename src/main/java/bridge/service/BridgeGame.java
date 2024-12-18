package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.Player;
import bridge.domain.TryCount;
import bridge.dto.BridgeSizeRequest;
import bridge.dto.MapResponse;
import bridge.dto.MovingRequest;
import bridge.dto.ResultResponse;
import bridge.util.BridgeRandomNumberGenerator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private TryCount tryCount = new TryCount();
    private final Player player = new Player();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void setUp(BridgeSizeRequest request) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(request.getBridgeSize()));
    }

    public boolean isPlaying() {
        return !player.isFinish(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(MovingRequest request) {
        return player.move(request.getMoving(), bridge);
    }

    public MapResponse map() {
        return MapResponse.of(bridge, player);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retrySetUp() {
        player.setUp();
        tryCount = tryCount.increase();
    }

    public ResultResponse result() {
        return ResultResponse.of(player, bridge, tryCount.get());
    }
}
