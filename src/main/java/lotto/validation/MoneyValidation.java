package lotto.validation;

import lotto.util.ErrorMessage;

public class MoneyValidation {

    ErrorMessage errorMessage;
    NumberValidation numberValidation;
    int convertedMoney;

    public MoneyValidation(String inputMoney) {
        errorMessage = new ErrorMessage();
        numberValidation = new NumberValidation();
        validate(inputMoney);
    }

    public void validate(String inputMoney) {
        numberValidation.isInputDigit(inputMoney);
        isInputInteger(inputMoney);
        convertedMoney = numberValidation.convertToInteger(inputMoney);
        isMoneyNegative(convertedMoney);
        isMoneyInsufficient(convertedMoney);
        isInputDividable(convertedMoney);
    }

    public int getMoney() {
        return convertedMoney;
    }

    public int getTicket() {
        return convertedMoney / 1000;
    }

    private void isInputInteger(String money) {
        if (Long.parseLong(money) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(errorMessage.illegalMoneyTypeMessage());
        }
    }

    private void isInputDividable(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(errorMessage.illegalMoneyMessage());
        }
    }

    private void isMoneyInsufficient(int money) {
        if (0 <= money && money < 1000) {
            throw new IllegalArgumentException(errorMessage.insufficientMoneyMessage());
        }
    }

    private void isMoneyNegative(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(errorMessage.negativeMoneyMessage());
        }
    }



}
