package lotto.validation;

import lotto.service.LottoSetting;
import lotto.view.LottoErrors;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.LottoErrors.*;


public class NumberValidation implements Predicate{

    private final String BREAK_POINT = ",";

    @Override
    public void test(String input) {
        try {
            isValidNumberAmount(input);
            numberRangeCheck(convertToList(input));
            isDuplicateNumber(convertToList(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void printError(LottoErrors lottoErrors) {
        throw new IllegalArgumentException(lottoErrors.getError());
    }

    private void isValidNumberAmount(String input) {
        if (input.split(BREAK_POINT).length != LottoSetting.NUMBER_AMOUNT.getAttribute()) {
            printError(ERROR_NUMBER_AMOUNT);
        }
    }

    private void numberRangeCheck(String[] convertedInput) {
        for (String number : convertedInput) {
            isMoneyDigit(number);
            isValidNumberRange(number);
        }
    }

    private void isMoneyDigit(String input) {
        if (!input.matches("[0-9]+")) {
            printError(ERROR_NON_DIGIT);
        }
    }

    private void isValidNumberRange(String number) {
        int convertedNumber = Integer.parseInt(number);
        if (convertedNumber < LottoSetting.START_NUMBER.getAttribute()
                && LottoSetting.END_NUMBER.getAttribute() < convertedNumber) {
//            throw new IllegalArgumentException(ERROR_NUMBER_RANGE.getError());
            printError(ERROR_NUMBER_RANGE);
        }
    }

    private void isDuplicateNumber(String[] convertedInput) {
        List<String> duplicateCheck = List.of(convertedInput).stream().distinct().collect(Collectors.toList());
        if (convertedInput.length != duplicateCheck.size()) {
            printError(ERROR_DUPLICATE_NUMBER);
        }
    }

    private String[] convertToList(String input) {
        return input.split(BREAK_POINT);
    }

}
