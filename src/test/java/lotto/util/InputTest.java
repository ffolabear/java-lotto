package lotto.util;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {

    @Nested
    @DisplayName("구매 금액 입력 테스트")
    class MoneyInputTest {

        @Test
        @DisplayName("입력값이 숫자가 아닐 때")
        void 입력값이_숫자가_아닐때() {
            assertThatThrownBy(() -> run("lotto"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력값이 나누어 떨어지지 않을 때")
        void 입력값이_나누어떨어지지_않을때() {
            assertThatThrownBy(() -> run("9400"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력값이 int 범위를 벗어날 때")
        void 입력값이_int_범위를_벗어날때() {
            assertThatThrownBy(() -> run(String.valueOf(Long.MAX_VALUE)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력값이 1000보다 작을 때")
        void 입력값이_1000보다_작을때() {
            assertThatThrownBy(() -> run("900"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 테스트")
    class WinningNumberTest{

        @Test
        @DisplayName("입력한 숫자가 6개가 아닐 때")
        void 숫자가_6개가_아닐때() {
            assertThatThrownBy(() -> run("1000", "1,2,3,4,5,"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자가 범위를 벗어날 때")
        void 숫자가_45를_넘을때() {
            assertThatThrownBy(() -> run("1000", "1,2,3,4,46,2"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자가 음수일 때")
        void 숫자가_음수일_때() {
            assertThatThrownBy(() -> run("1000", "1,2,3,4,45,-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복된 숫자를 입력할 때")
        void 중복된_숫자를_입력할_때() {
            assertThatThrownBy(() -> run("1000", "1,2,3,4,45,1"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
