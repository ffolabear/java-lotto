package lotto.validation;

import lotto.view.LottoErrors;

import static lotto.view.LottoErrors.ERROR_NON_DIGIT;
import static lotto.view.LottoErrors.ERROR_NON_DIVIDABLE;

public class MoneyValidation implements Predicate {

    @Override
    public void test(String input) {
        try {
            isMoneyDigit(input);
            isMoneyDividable(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void printError(LottoErrors lottoErrors){
        throw new IllegalArgumentException(lottoErrors.getError());
    }

    private void isMoneyDigit(String input) {
        if (!input.matches("[0-9]+")) {
            printError(ERROR_NON_DIGIT);
            throw new IllegalArgumentException();
        }
    }

    private void isMoneyDividable(String input) {
        if (convertToLong(input) % 1000 != 0) {
            printError(ERROR_NON_DIVIDABLE);
            throw new IllegalArgumentException();
        }
    }

    private long convertToLong(String input) {
        return Long.parseLong(input);
    }

}
