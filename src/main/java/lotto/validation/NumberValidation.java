package lotto.validation;

import lotto.service.LottoSetting;
import lotto.view.LottoErrors;

public class NumberValidation implements Predicate{

    private final String BREAK_POINT = ",";

    @Override
    public void test(String input) {
        try {
            isValidNumberAmount(input);
            numberRangeCheck(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void isValidNumberAmount(String input) {
        if (input.split(BREAK_POINT).length != LottoSetting.NUMBER_AMOUNT.getAttribute()) {
            throw new IllegalArgumentException(LottoErrors.ERROR_NUMBER_AMOUNT.getError());
        }
    }

    private void numberRangeCheck(String input) {
        String[] numbers = input.split(BREAK_POINT);
        for (String number : numbers) {
            isMoneyDigit(number);
            isValidNumberRange(number);
        }
    }

    private void isMoneyDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(LottoErrors.ERROR_NON_DIGIT.getError());
        }
    }

    private void isValidNumberRange(String number) {
        int convertedNumber = Integer.parseInt(number);
        if (convertedNumber < LottoSetting.START_NUMBER.getAttribute()
                && LottoSetting.END_NUMBER.getAttribute() < convertedNumber) {
            throw new IllegalArgumentException(LottoErrors.ERROR_NUMBER_RANGE.getError());
        }
    }

}
