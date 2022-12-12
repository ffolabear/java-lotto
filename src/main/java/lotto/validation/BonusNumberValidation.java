package lotto.validation;

import lotto.view.LottoErrors;

import java.util.List;

import static lotto.view.LottoErrors.ERROR_INVALID_BONUS_NUMBER;

public class BonusNumberValidation implements Predicate {

    private final List<Integer> winningNumbers;

    public BonusNumberValidation(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void test(String input) {
        isDuplicateNumber(input);
    }

    @Override
    public String printError(LottoErrors lottoErrors) {
        return lottoErrors.getError();
    }

    @Override
    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    private void isDuplicateNumber(String input) {
        if (winningNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(printError(ERROR_INVALID_BONUS_NUMBER));
        }
    }

}
