package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void 입력한_문자에_따라_이동한다() {
        Player player = new Player();
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);//아래칸으로 고정
        List<String> bridge = bridgeMaker.makeBridge(20);

        player.move("U", bridge);
        player.move("D", bridge);
    }

    @Test
    void 입력한_문자가_잘못된_경우_예외를_반환한다() {
        Player player = new Player();
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);//아래칸으로 고정
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThatThrownBy(() -> player.move("J", bridge)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동가능_여부에_따라_표시한다() {
        Player player = new Player();
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);//아래칸으로 고정
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(player.move("U", bridge)).isFalse();
        assertThat(player.move("D", bridge)).isTrue();
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
