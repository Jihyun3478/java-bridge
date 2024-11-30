package bridge.dto;

import java.util.List;

import bridge.domain.Player;

public class MapResponse {
    private final List<String> bridge;

    public MapResponse(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public static MapResponse of(List<String> bridge, Player player) {
        return new MapResponse(bridge.subList(0, player.lastTryResult() ? player.getPosition() : player.getPosition()+1));
    }
}
