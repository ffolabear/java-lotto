package lotto.validation;

import lotto.view.LottoErrors;

public class MoneyValidation implements Predicate {

    @Override
    public void test(String input) {
        try {
            isMoneyDigit(input);
            isMoneyDividable(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void isMoneyDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(LottoErrors.ERROR_NON_DIGIT.getError());
        }
    }

    private void isMoneyDividable(String input) {
        if (convertToLong(input) % 1000 != 0) {
            throw new IllegalArgumentException(LottoErrors.ERROR_NON_DIVIDABLE.getError());
        }
    }

    private long convertToLong(String input) {
        return Long.parseLong(input);
    }
}
