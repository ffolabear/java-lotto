package lotto.validation;

public class MoneyValidation {

    public int validateMoney(String inputMoney) {
        int convertedInput = isInputInteger(inputMoney);
        isInputDividable(convertedInput);
        return convertedInput;
    }

    private int isInputInteger(String inputMoney) {
        int convertedInput = 0;
        try {
            convertedInput = Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return convertedInput;
    }

    private void isInputDividable(int convertedInput) {
        if (convertedInput % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
