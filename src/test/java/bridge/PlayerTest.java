package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import bridge.domain.BridgeMaker;
import bridge.domain.Player;

class PlayerTest {
    @Test
    void 입력한_문자에_따라_이동한다() {
        Player player = new Player();
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);//아래칸으로 고정
        List<String> bridge = bridgeMaker.makeBridge(20);

        player.move(true, bridge);
        player.move(false, bridge);
    }

    @Test
    void 이동가능_여부에_따라_표시한다() {
        Player player = new Player();
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);//아래칸으로 고정
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(player.move(true, bridge)).isFalse();
        assertThat(player.move(false, bridge)).isTrue();
        assertThat(player.getPosition()).isEqualTo(1);
    }

    @Test
    void 다리를_끝까지_건너면_종료한다() {
        Player player = new Player(20);
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);//아래칸으로 고정
        List<String> bridge = bridgeMaker.makeBridge(20);

        assertThat(player.isFinish(bridge)).isTrue();
    }

    @Test
    void 다리를_끝까지_건너지_않으면_종료하지_않는다() {
        Player player = new Player(10);
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);//아래칸으로 고정
        List<String> bridge = bridgeMaker.makeBridge(20);

        assertThat(player.isFinish(bridge)).isFalse();
    }
}
