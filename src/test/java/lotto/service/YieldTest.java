package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.*;

public class YieldTest extends NsTest {


    @Test
    @DisplayName("수익률 계산 테스트")
    void validYieldTest() {
        Map<Integer, Integer> drawResult = Map.of(
                3, 1,
                4, 0,
                5, 0,
                6, 0
        );

        int bonusMatched = 0;
        int userMoney = 8000;
        CalculateYield c = new CalculateYield(drawResult, bonusMatched, userMoney);
        String yield = c.getYield();
        Assertions.assertThat(yield).isEqualTo("62.5");
    }

    @Test
    @DisplayName("수익률을 0으로 나눌때 테스트")
    void nonDividableYield() {
        ErrorMessage errorMessage = new ErrorMessage();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("0", "1,2,3,4,5,6", "7");
                    Assertions.assertThat(output()).contains(errorMessage.insufficientMoneyMessage());
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
