package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoDraw;
import lotto.service.PurchaseLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("사용자가 입력한 금액만큼의 로또를 생성하는지")
    void 입력한_금액만큼의_로또구매_테스트() {
        PurchaseLotto purchaseLotto = new PurchaseLotto(10);
        assertThat(purchaseLotto.getPurchasedLottoList().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("보너스 번호가 존재할 때")
    void 보너스번호_추첨_테스트() {
        List<List<Integer>> generatedLotto = List.of(
                List.of(11, 12, 13, 14, 15, 16),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(13, 14, 15, 16, 17, 18),
                List.of(14, 15, 16, 17, 18, 45),
                List.of(15, 16, 17, 18, 19, 20)
        );
        List<Integer> winningNumbers = List.of(14, 15, 16, 17, 18, 34);
        int bonusNumber = 45;
        LottoDraw lottoDraw = new LottoDraw(generatedLotto, winningNumbers, bonusNumber);
        lottoDraw.startDraw();
        assertThat(lottoDraw.getBonusNumberMatched()).isEqualTo(1);
    }

    @Test
    @DisplayName("추첨 결과에 보너스등수 당첨 포함하는지 테스트")
    void 추첨결과에_보너스등수_반영여부_테스트() {
        List<List<Integer>> generatedLotto = List.of(
                List.of(1, 2, 3, 11, 12, 13),
                List.of(1, 2, 3, 21, 22, 23),

                List.of(1, 2, 3, 21, 24, 40),
                List.of(1, 2, 3, 21, 24, 40),
                List.of(1, 2, 3, 21, 24, 40),
                List.of(1, 2, 3, 21, 24, 45),

                List.of(1, 2, 3, 21, 24, 26)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 21, 24, 26);
        int bonusNumber = 45;
        LottoDraw lottoDraw = new LottoDraw(generatedLotto, winningNumbers, bonusNumber);
        lottoDraw.startDraw();
        assertThat(lottoDraw.getDrawResult().get(5) + lottoDraw.getBonusNumberMatched()).isEqualTo(4);
    }

    @Test
    void 일치하는_로또가_없을때_테스트() {
        List<List<Integer>> generatedLotto = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(3, 4, 5, 6, 7, 8),
                List.of(4, 5, 6, 7, 8, 9),
                List.of(5, 6, 7, 8, 9, 10),
                List.of(6, 7, 8, 9, 10, 11),
                List.of(7, 8, 9, 10, 11, 12)
        );
        List<Integer> winningNumbers = List.of(40, 41, 42, 43, 44, 45);
        int bonusNumber = 6;
        LottoDraw lottoDraw = new LottoDraw(generatedLotto, winningNumbers, bonusNumber);
        lottoDraw.startDraw();
        Map<Integer, Integer> drawResult = lottoDraw.getDrawResult();
        for (int numberMatch : drawResult.keySet()) {
            assertThat(drawResult.get(numberMatch)).isEqualTo(0);
        }
    }
}
