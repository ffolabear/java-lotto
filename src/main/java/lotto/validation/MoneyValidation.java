package lotto.validation;

import lotto.view.LottoErrors;

import static lotto.view.LottoErrors.ERROR_MONEY_EXCESS;
import static lotto.view.LottoErrors.ERROR_NON_DIVIDABLE;

public class MoneyValidation implements Predicate {

    private final CommonValidation commonValidation = new CommonValidation();

    @Override
    public void test(String input) {
        commonValidation.isInputDigit(input);
        isMoneyExcess(input);
        isMoneyDividable(convertToInteger(input));
    }

    @Override
    public String printError(LottoErrors lottoErrors) {
        return lottoErrors.getError();
    }

    @Override
    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    private void isMoneyExcess(String input) {
        if (Long.parseLong(input) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(printError(ERROR_MONEY_EXCESS));
        }
    }

    private void isMoneyDividable(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(printError(ERROR_NON_DIVIDABLE));
        }
    }

}
