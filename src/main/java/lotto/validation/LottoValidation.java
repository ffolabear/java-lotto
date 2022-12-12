package lotto.validation;

import lotto.service.LottoSetting;

import java.util.List;

public class LottoValidation {

    private final List<Integer> lottoNumbers;
    private boolean isValidLotto = true;

    public LottoValidation(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void validate() {
        isValidAmount();
        numberRangeCheck();
        isDuplicateNumber();
        if (!isValidLotto) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidAmount() {
        if (lottoNumbers.size() != LottoSetting.NUMBER_AMOUNT.getAttribute()) {
            isValidLotto = false;
            throw new IllegalArgumentException();
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

    private void isDuplicateNumber() {
        int numberCount = (int)lottoNumbers.stream().distinct().count();
        if (numberCount != lottoNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

}
