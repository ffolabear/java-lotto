package lotto.validation;

import lotto.service.LottoSetting;
import lotto.view.LottoErrors;

import static lotto.view.LottoErrors.ERROR_NON_DIGIT;
import static lotto.view.LottoErrors.ERROR_NUMBER_RANGE;

public class CommonValidation implements Predicate{

    @Override
    public void test(String input) {
        try {
            isInputDigit(input);
            isValidNumberRange(convertToInteger(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void isInputDigit(String input) {
        if (!input.matches("[0-9]+")) {
            printError(ERROR_NON_DIGIT);
        }
    }

    public void isValidNumberRange(int number) {
        if (number < LottoSetting.START_NUMBER.getAttribute()
                && LottoSetting.END_NUMBER.getAttribute() < number) {
            printError(ERROR_NUMBER_RANGE);
        }
    }

    @Override
    public void printError(LottoErrors lottoErrors) {
        throw new IllegalArgumentException(lottoErrors.getError());
    }

    @Override
    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }
}
