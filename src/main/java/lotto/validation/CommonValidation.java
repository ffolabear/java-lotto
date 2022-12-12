package lotto.validation;

import lotto.service.LottoSetting;
import lotto.view.LottoErrors;

import static lotto.view.LottoErrors.ERROR_NON_DIGIT;
import static lotto.view.LottoErrors.ERROR_NUMBER_RANGE;

public class CommonValidation implements Predicate{

    @Override
    public void test(String input) {
//        try {
//            isInputDigit(input);
//            isValidNumberRange(convertToInteger(input));
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
////            throw new IllegalArgumentException(e.getMessage());
//        }

        isInputDigit(input);
        isValidNumberRange(convertToInteger(input));
    }

    public void isInputDigit(String input) {
        if (!input.matches("[0-9]+")) {
//            printError(ERROR_NON_DIGIT);
            throw new IllegalArgumentException(errorMessage(ERROR_NON_DIGIT));
        }
    }

    public void isValidNumberRange(int number) {
        if (number < LottoSetting.START_NUMBER.getAttribute()
                && LottoSetting.END_NUMBER.getAttribute() < number) {
//            printError(ERROR_NUMBER_RANGE);
            throw new IllegalArgumentException(errorMessage(ERROR_NUMBER_RANGE));
        }
    }

    public String errorMessage(LottoErrors errors) {
        return errors.getError();
    }

    @Override
    public void printError(LottoErrors lottoErrors) throws IllegalArgumentException{
        throw new IllegalArgumentException(lottoErrors.getError());
    }

    @Override
    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }
}
