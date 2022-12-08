package lotto.validation;

import lotto.view.LottoErrors;

import static lotto.view.LottoErrors.ERROR_MONEY_EXCESS;
import static lotto.view.LottoErrors.ERROR_NON_DIVIDABLE;

public class MoneyValidation implements Predicate {

    private final CommonValidation commonValidation = new CommonValidation();

    @Override
    public void test(String input) {
        try {
            commonValidation.isInputDigit(input);
            isMoneyExcess(input);
            isMoneyDividable(convertToInteger(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void printError(LottoErrors lottoErrors){
        throw new IllegalArgumentException(lottoErrors.getError());
    }

    @Override
    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    private void isMoneyExcess(String input) {
        if (Long.parseLong(input) > Integer.MAX_VALUE) {
            printError(ERROR_MONEY_EXCESS);
            throw new IllegalArgumentException();
        }
    }

    private void isMoneyDividable(int money) {
        if (money % 1000 != 0) {
            printError(ERROR_NON_DIVIDABLE);
            throw new IllegalArgumentException();
        }
    }

}
