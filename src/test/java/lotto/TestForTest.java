package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;

public class TestForTest extends NsTest {

    @Test
    @DisplayName("기능 테스트")
    void basicFunctionTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "1,2,3,4,5,6", "7");
                },
                List.of(1,2,    8,9,10,11),

                List.of(1,2,3   ,8,9,10),
                List.of(1,2,3   ,8,9,11),

                List.of(1,2,3,4,    9,10),
                List.of(1,2,3,4,    9,10),
                List.of(1,2,3,4,    9,10),

                List.of(1,2,3,4,5,  10),
                List.of(1,2,3,4,5,  10),

                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,6)
        );
    }

    @Test
    @DisplayName("수익률 테스트")
    void yieldTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                },
                List.of(1,2,    8,9,10,11),
                List.of(1,2,    8,9,10,11),
                List.of(1,2,    8,9,10,11),
                List.of(1,2,    8,9,10,11),
                List.of(1,2,3,4,5,      10)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
