package bridge.dto;

import static bridge.constant.BridgeConstant.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import bridge.domain.Bridge;
import bridge.domain.Player;

public class MapResponse {
    private static final String DEFAULT_O = "O";
    private static final String DEFAULT_X = "X";
    private static final String PRIVATE_X = " ";

    private final List<String> upBridge;
    private final List<String> downBridge;

    public MapResponse(List<String> upBridge, List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public static MapResponse of(Bridge bridge, Player player) {
        List<String> resultUp = convertBridge(bridge, player, UP);
        List<String> resultDown = convertBridge(bridge, player, DOWN);

        return new MapResponse(resultUp, resultDown);
    }

    private static List<String> convertBridge(Bridge bridge, Player player, String target) {
        String o = DEFAULT_O;
        String x = player.lastTryResult() ? PRIVATE_X : DEFAULT_X;

        List<String> result = bridge.getList().stream()
            .map(direction -> {
                    if (Objects.equals(direction, target)) {
                        return o;
                    }
                    return x;
                }
            ).collect(Collectors.toList());

        if (player.lastTryResult()) {
            return result.subList(0, player.getPosition());
        }
        return result.subList(0, player.getPosition() + 1);
    }
}
