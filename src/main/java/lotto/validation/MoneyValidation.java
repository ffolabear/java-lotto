package lotto.validation;

public class MoneyValidation implements InputValidation {

    int convertedMoney;

    public void validate(String money) {
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

    @Override
    public void isInputInteger(String money) {
        try {
            Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int convertToInteger(String money) {
        return Integer.parseInt(money);
    }

    private void isInputDividable(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
