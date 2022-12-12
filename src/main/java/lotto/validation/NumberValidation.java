package lotto.validation;

import lotto.service.LottoSetting;
import lotto.view.LottoErrors;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.LottoErrors.ERROR_NUMBER_AMOUNT;
import static lotto.view.LottoErrors.ERROR_NON_DIGIT;
import static lotto.view.LottoErrors.ERROR_NUMBER_RANGE;
import static lotto.view.LottoErrors.ERROR_DUPLICATE_NUMBER;

public class NumberValidation implements Predicate {

    private final String BREAK_POINT = ",";

    @Override
    public void test(String input) {
        isValidNumberAmount(input);
        numberRangeCheck(convertToList(input));
        isDuplicateNumber(convertToList(input));
    }

    @Override
    public String printError(LottoErrors lottoErrors) {
        return lottoErrors.getError();
    }

    @Override
    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    private void isValidNumberAmount(String input) {
        if (input.split(BREAK_POINT).length != LottoSetting.NUMBER_AMOUNT.getAttribute()) {
            throw new IllegalArgumentException(printError(ERROR_NUMBER_AMOUNT));
        }
    }

    private void numberRangeCheck(String[] convertedInput) {
        for (String number : convertedInput) {
            isMoneyDigit(number);
            isValidNumberRange(convertToInteger(number));
        }
    }

    public void isMoneyDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(printError(ERROR_NON_DIGIT));
        }
    }

    public void isValidNumberRange(int number) {
        if (number < LottoSetting.START_NUMBER.getAttribute() || LottoSetting.END_NUMBER.getAttribute() < number) {
            throw new IllegalArgumentException(printError(ERROR_NUMBER_RANGE));
        }
    }

    private void isDuplicateNumber(String[] convertedInput) {
        List<String> duplicateCheck = List.of(convertedInput).stream().distinct().collect(Collectors.toList());
        if (convertedInput.length != duplicateCheck.size()) {
            throw new IllegalArgumentException(printError(ERROR_DUPLICATE_NUMBER));
        }
    }

    private String[] convertToList(String input) {
        return input.split(BREAK_POINT);
    }

}
