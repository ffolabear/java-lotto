package lotto.validation;

import java.util.ArrayList;
import java.util.List;

public class NumberValidation {

    final int START_NUMBER = 1;
    final int END_NUMBER = 45;
    final int NUMBERS_AMOUNT = 6;

    List<Integer> convertedNumbers = new ArrayList<>();

    public List<Integer> validateNumbers(List<String> inputLottoNumbers) {
        isValidAmountNumbers(inputLottoNumbers);
        for (String number : inputLottoNumbers) {
            int convertedNumber =  isInputNumberInteger(number);
            isValidRange(convertedNumber);
            convertedNumbers.add(convertedNumber);
        }
        return convertedNumbers;
    }

    private void isValidAmountNumbers(List<String> inputLottoNumbers) {
        if (inputLottoNumbers.size() != NUMBERS_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    private int isInputNumberInteger(String inputNumber) {
        int convertedInput = 0;
        try {
            convertedInput = Integer.parseInt(inputNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return convertedInput;
    }

    private void isValidRange(int convertedNumber) {
        if (convertedNumber < START_NUMBER || END_NUMBER < convertedNumber) {
            throw new IllegalArgumentException();
        }
    }
}
