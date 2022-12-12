package lotto.util;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.*;

public class InputTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구매 금액 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"apple", "222", "  "})
    void moneyInputTest(String input) {
        assertSimpleTest(() -> {
            run(input);
            Assertions.assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,4,5", "1,2,3,4,47", "1,1,1,2,3,4","  "})
    void numberInputTest(String input) {
        assertSimpleTest(() -> {
            run(input);
            Assertions.assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
