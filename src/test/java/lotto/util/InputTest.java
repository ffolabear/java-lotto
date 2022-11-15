package lotto.util;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.view.ErrorDetail.*;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Nested
    @DisplayName("구매 금액 입력 테스트")
    class MoneyInputTest {

        @Test
        @DisplayName("금액이 숫자가 아닐 때")
        void 입력값이_숫자가_아닐때() {
            assertSimpleTest(() -> {
                runException("lotto");
                assertThat(output()).contains(ERROR_MESSAGE)
                .contains(ERROR_ILLEGAL_INPUT.getError());
            });
        }

        @Test
        @DisplayName("금액이 나누어 떨어지지 않을 때")
        void 입력값이_나누어떨어지지_않을때() {
            assertSimpleTest(() -> {
                runException("9400");
                assertThat(output()).contains(ERROR_MESSAGE)
                .contains(ERROR_NON_DIVIDABLE.getError());
            });
        }

        @Test
        @DisplayName("금액이 int 범위를 벗어날 때")
        void 입력값이_int_범위를_벗어날때() {
            assertSimpleTest(() -> {
                runException(String.valueOf(Long.MAX_VALUE));
                assertThat(output()).contains(ERROR_MESSAGE)
                        .contains(ERROR_NON_INTEGER.getError());
            });
        }

        @Test
        @DisplayName("금액이 1000보다 작을 때")
        void 입력값이_1000보다_작을때() {
            assertSimpleTest(() -> {
                runException("900");
                assertThat(output()).contains(ERROR_MESSAGE)
                        .contains(ERROR_INSUFFICIENT_MONEY.getError());
            });
        }

        @Test
        @DisplayName("금액이 음수일 때")
        void 입력값이_음수일때() {
            assertSimpleTest(() -> {
                runException("-1000");
                assertThat(output()).contains(ERROR_MESSAGE)
                        .contains(ERROR_NEGATIVE_MONEY.getError());
            });
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 테스트")
    class WinningNumberTest{

        @Test
        @DisplayName("입력한 숫자가 6개가 아닐 때")
        void 숫자가_6개가_아닐때() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,");
                assertThat(output()).contains(ERROR_MESSAGE)
                        .contains(ERROR_NUMBER_AMOUNT.getError());
            });
        }

        @Test
        @DisplayName("숫자가 범위를 벗어날 때")
        void 숫자가_45를_넘을때() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,46,2");
                assertThat(output()).contains(ERROR_MESSAGE)
                        .contains(ERROR_RANGE.getError());
            });
        }

        @Test
        @DisplayName("숫자가 음수일 때")
        void 숫자가_음수일_때() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,45,-1");
                assertThat(output()).contains(ERROR_MESSAGE)
                        .contains(ERROR_RANGE.getError());
            });
        }

        @Test
        @DisplayName("중복된 숫자를 입력할 때")
        void 중복된_숫자를_입력할_때() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,45,1");
                assertThat(output()).contains(ERROR_MESSAGE)
                        .contains(ERROR_DUPLICATE_NUMBER.getError());
            });
        }

        @Test
        @DisplayName("중복된 보너스 번호를 입력할 때")
        void 중복된_보너스번호를_입력할_때() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,32,12,45,7", "32");
                assertThat(output()).contains(ERROR_MESSAGE)
                        .contains(ERROR_DUPLICATE_BONUS_NUMBER.getError());
            });
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
