package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import bridge.domain.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;

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

    @Test
    void 다리_길이가_올바르게_생성되는지_확인한다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(20);

        assertThat(bridge.size()).isEqualTo(20);
    }
}
