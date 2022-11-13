package lotto.validation;

import lotto.util.ErrorMessage;

import java.util.List;

public class BonusNumberValidation {

    NumberValidation numberValidation;
    ErrorMessage errorMessage;
    List<Integer> winningNumbers;
    String inputBonusNumber;
    int bonusNumber;

    public BonusNumberValidation(List<Integer> winningNumbers, String inputBonusNumber) {
        this.errorMessage = new ErrorMessage();
        this.winningNumbers = winningNumbers;
        this.numberValidation = new NumberValidation();
        this.inputBonusNumber = inputBonusNumber;
    }

    public int getValidatedBonusNumber() {
        return bonusNumber;
    }

    public void validate() {
        numberValidation.isInputDigit(inputBonusNumber);
        bonusNumber = numberValidation.convertToInteger(inputBonusNumber);
        numberValidation.isValidRange(bonusNumber);
        checkDuplication();
    }

    private void checkDuplication() {
        if (winningNumbers.contains(bonusNumber)) {
            errorMessage.duplicateBonusNumberMessage();
            throw new IllegalArgumentException();
        }
    }
}
