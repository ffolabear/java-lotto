package lotto.validation;

import lotto.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidation {

    ErrorMessage errorMessage;
    String winningNumbers;
    List<Integer> convertedNumbers;

    public LottoValidation() {
        errorMessage = new ErrorMessage();
    }

    public List<Integer> getValidatedWinningNumber() {
        return convertedNumbers;
    }

    public void validate(String winningNumbers) {
        this.winningNumbers = winningNumbers;
        List<String> rawNumbers = convertToStringNumberList();
        convertedNumbers = convertToIntegerNumberList(rawNumbers);
        isValidAmount(convertedNumbers);
        checkDuplication(convertedNumbers);
    }

    private List<String> convertToStringNumberList() {
        return new ArrayList<>(List.of(winningNumbers.split(",")));
    }

    private List<Integer> convertToIntegerNumberList(List<String> rawNumbers) {
        convertedNumbers = new ArrayList<>();
        for (String number : rawNumbers) {
            NumberValidation numberValidation = new NumberValidation();
            numberValidation.isInputDigit(number);
            int convertedNumber = numberValidation.convertToInteger(number);
            numberValidation.isValidRange(convertedNumber);
            convertedNumbers.add(convertedNumber);
        }
        return convertedNumbers;
    }

    private void isValidAmount(List<Integer> convertedNumbers) {
        if (convertedNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.illegalNumberAmountMessage());
        }
    }

    public void checkDuplication(List<Integer> convertedNumbers) {
        List<Integer> checkingDuplication = convertedNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (checkingDuplication.size() != convertedNumbers.size()) {
            throw new IllegalArgumentException(errorMessage.duplicateNumberMessage());
        }
    }
}
