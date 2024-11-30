package bridge.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import bridge.domain.Player;

public class MapResponse {
    private static final String DEFAULT_O = "O";
    private static final String DEFAULT_X = "X";
    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";

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

    public static MapResponse of(List<String> bridge, Player player) {
        List<String> resultUp = convertBridge(bridge, player, UP_BRIDGE);
        List<String> resultDown = convertBridge(bridge, player, DOWN_BRIDGE);

        return new MapResponse(resultUp, resultDown);
    }

    private static List<String> convertBridge(List<String> bridge, Player player, String target) {
        String o = DEFAULT_O;
        String x = player.lastTryResult() ? " " : DEFAULT_X;

        return bridge.stream().map(direction -> {
                if(Objects.equals(direction, target)) {
                    return o;
                }
                return x;
            }
        ).collect(Collectors.toList());
    }
}
