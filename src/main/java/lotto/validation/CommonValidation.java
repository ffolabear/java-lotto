package lotto.validation;

import lotto.service.LottoSetting;
import lotto.view.LottoErrors;

import static lotto.view.LottoErrors.ERROR_NON_DIGIT;
import static lotto.view.LottoErrors.ERROR_NUMBER_RANGE;

public class CommonValidation implements Predicate {

    @Override
    public void test(String input) {
        isInputDigit(input);
        isValidNumberRange(convertToInteger(input));
    }

    public void isInputDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(printError(ERROR_NON_DIGIT));
        }
    }

    public void isValidNumberRange(int number) {
        if (number < LottoSetting.START_NUMBER.getAttribute()
                && LottoSetting.END_NUMBER.getAttribute() < number) {
            throw new IllegalArgumentException(printError(ERROR_NUMBER_RANGE));
        }
    }

    @Override
    public String printError(LottoErrors lottoErrors) {
        return lottoErrors.getError();
    }

    @Override
    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }
}
