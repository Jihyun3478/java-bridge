package bridge.dto;

import java.util.List;

import bridge.domain.Player;

public class MapResponse {
    private final List<String> bridge;
    private final boolean lastTryResult;

    public MapResponse(List<String> bridge, boolean lastTryResult) {
        this.bridge = bridge;
        this.lastTryResult = lastTryResult;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean lastTryResult() {
        return lastTryResult;
    }

    public static MapResponse of(List<String> bridge, Player player) {
        return new MapResponse(bridge.subList(0, player.lastTryResult() ? player.getPosition() : player.getPosition()+1),
            player.lastTryResult());
    }
}
