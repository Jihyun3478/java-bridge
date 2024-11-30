package bridge.domain;

public class TryCount {
    private static final int DEFAULT_TRY_COUNT = 1;

    private final int tryCount;

    public TryCount() {
        tryCount = DEFAULT_TRY_COUNT;
    }

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public TryCount increase() {
        return new TryCount(tryCount + 1);
    }

    public int get() {
        return tryCount;
    }
}
