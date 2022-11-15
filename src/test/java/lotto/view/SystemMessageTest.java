package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;

public class SystemMessageTest extends NsTest {

    @Test
    @DisplayName("금액입력 메세지 출력 테스트")
    void 시작_메세지_테스트() {
        assertSimpleTest(() -> {
            runException("");
            assertThat(output()).contains(MessageDetail.INPUT_MONEY.getMessage());
        });
    }

    @Test
    @DisplayName("로또 구매 결과 메세지 출력 테스트")
    void 금액입력_메세지_테스트() {
        assertSimpleTest(() -> {
            runException("7000");
            assertThat(output()).contains(String.format(MessageDetail.PURCHASE_RESULT.getMessage(), "7"));
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 메세지 출력 테스트")
    void 당첨번호_입력메세지_테스트() {
        assertSimpleTest(() -> {
            runException("7000");
            assertThat(output()).contains(MessageDetail.INPUT_WINNING_NUMBERS.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 메세지 출력 테스트")
    void 보너스번호_입력메세지_테스트() {
        assertSimpleTest(() -> {
            runException("7000", "1,2,3,4,5,6");
            assertThat(output()).contains(MessageDetail.INPUT_BONUS_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("생성된 로또 번호 정렬 후 출력 테스트")
    void 로또번호_정렬_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]"
                    );
                },
                List.of(35, 36, 16, 44, 7, 11),
                List.of(1, 42, 41, 31, 11, 8),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(30, 40, 42, 43, 7, 11),
                List.of(22, 32, 38, 45, 2, 13)
        );
    }

    @Test
    @DisplayName("추첨 결과 메세지 테스트")
    void 추첨결과_메세지_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[4, 5, 6, 11, 12, 13]",
                            "[1, 4, 5, 6, 13, 14]",
                            "[1, 2, 4, 5, 6, 13]",
                            "[1, 2, 4, 5, 6, 7]",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(6, 5, 4, 11, 12, 13),
                List.of(6, 5, 4, 1, 13, 14),
                List.of(6, 5, 4, 1, 2, 13),
                List.of(6, 5, 4, 1, 2, 7),
                List.of(6, 5, 4, 1, 2, 3)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
