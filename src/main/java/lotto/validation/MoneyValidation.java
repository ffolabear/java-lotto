package lotto.validation;

import lotto.util.ErrorMessage;

public class MoneyValidation implements InputValidation {

    int convertedMoney;
    ErrorMessage errorMessage = new ErrorMessage();

    public void validate(String money) {
        isInputDigit(money);
        isInputInteger(money);
        convertedMoney = convertToInteger(money);
        isInputDividable(convertedMoney);
    }

    public int getMoney() {
        return convertedMoney;
    }

    public int getTicket() {
        return convertedMoney / 1000;
    }

    public void isInputInteger(String money) {
        if (Long.parseLong(money) > Integer.MAX_VALUE) {
            errorMessage.illegalMoneyTypeMessage();
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void isInputDigit(String money) {
        if (!money.matches("[0-9]+")) {
            errorMessage.illegalArgumentMessage();
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int convertToInteger(String money) {
        return Integer.parseInt(money);
    }

    private void isInputDividable(int money) {
        if (money % 1000 != 0) {
            errorMessage.illegalMoneyMessage();
            throw new IllegalArgumentException();
        }
    }

}
