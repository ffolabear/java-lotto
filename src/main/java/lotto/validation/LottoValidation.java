package lotto.validation;

import lotto.service.LottoSetting;

import java.util.List;

public class LottoValidation {

    private final List<Integer> lottoNumbers;
    private boolean isValidLotto = true;
    private final CommonValidation commonValidation = new CommonValidation();

    public LottoValidation(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    public void validate() {
        isValidAmount();
        numberRangeCheck();
        if (!isValidLotto) {
            throw new RuntimeException();
        }
    }

    private void isValidAmount() {
        if (lottoNumbers.size() != LottoSetting.NUMBER_AMOUNT.getAttribute()) {
            isValidLotto = false;
        }
    }

    private void numberRangeCheck() {
        for (int number : lottoNumbers) {
            commonValidation.isValidNumberRange(number);
        }
    }

}
