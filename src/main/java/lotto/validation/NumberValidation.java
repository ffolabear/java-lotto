package lotto.validation;

import lotto.util.ErrorMessage;

public class NumberValidation implements InputValidation {

    ErrorMessage errorMessage;

    public NumberValidation() {
        errorMessage = new ErrorMessage();
    }

    @Override
    public void isInputDigit(String number) {
        if (!number.matches("[0-9]+")) {
            errorMessage.illegalArgumentMessage();
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    public void isValidRange(int convertedNumber) {
        if (convertedNumber < LottoSetting.START_NUMBER.getValue() || LottoSetting.END_NUMBER.getValue() < convertedNumber) {
            errorMessage.illegalNumberRangeMessage();
            throw new IllegalArgumentException();
        }
    }

}