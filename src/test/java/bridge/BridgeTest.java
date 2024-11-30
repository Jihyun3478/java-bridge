package bridge;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class BridgeTest {

    @Test
    void 위아래_두칸으로_이루어진_다리를_생성한다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(20);
        Optional<String> result = bridge.stream()
            .filter(number -> !number.equals("U"))
            .filter(number -> !number.equals("D"))
            .findAny();
        assertThat(result.isPresent()).isFalse();
    }
}
