package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void 입력한_문자에_따라_이동한다() {
        Player player = new Player();
        player.move("U");
        player.move("D");
    }

    @Test
    void 입력한_문자가_잘못된_경우_예외를_반환한다() {
        Player player = new Player();

        assertThatThrownBy(() -> player.move("J")).isInstanceOf(IllegalArgumentException.class);
    }
}
