package bridge.domain;

import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public boolean equalsTo(int position, String up) {
        return bridge.get(position).equals(up);
    }

    public List<String> getList() {
        return bridge;
    }
}
