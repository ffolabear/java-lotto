package lotto.validation;

import lotto.service.LottoSetting;
import lotto.view.LottoErrors;

import java.util.List;

public class LottoValidation {

    private final List<Integer> lottoNumbers;
    private boolean isValidLotto = true;

    public LottoValidation(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean validate() {
        isValidAmount();
        numberRangeCheck();
        return isValidLotto;
    }

    private void isValidAmount() {
        if (lottoNumbers.size() != LottoSetting.NUMBER_AMOUNT.getAttribute()) {
            isValidLotto = false;
        }
    }

    private void numberRangeCheck() {
        for (int number : lottoNumbers) {
            isValidNumberRange(number);
        }
    }

    private void isValidNumberRange(int number) {
        if (number < LottoSetting.START_NUMBER.getAttribute()
                && LottoSetting.END_NUMBER.getAttribute() < number) {
            isValidLotto = false;
        }
    }

}
