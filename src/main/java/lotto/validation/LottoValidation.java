package lotto.validation;

import lotto.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidation implements InputValidation {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int NUMBER_AMOUNT = 6;
    List<Integer> convertedNumbers;
    ErrorMessage errorMessage = new ErrorMessage();

    public void validate(String numbers) {
        List<String> rawNumbers = convertToStringNumberList(numbers);
        convertedNumbers = convertToIntegerNumberList(rawNumbers);
        checkDuplication(convertedNumbers);
    }

    @Override
    public void isInputNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            errorMessage.illegalArgumentMessage();
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    public List<Integer> getValidNumbers() {
        return convertedNumbers;
    }

    private List<String> convertToStringNumberList(String numbers) {
        return new ArrayList<>(List.of(numbers.split(",")));
    }

    private List<Integer> convertToIntegerNumberList(List<String> rawNumbers) {
        convertedNumbers = new ArrayList<>();
        for (String number : rawNumbers) {
            isInputNumber(number);
            isValidRange(number);
            convertedNumbers.add(convertToInteger(number));
        }
        return convertedNumbers;
    }

    private void isValidRange(String number) {
        int convertedNumber = Integer.parseInt(number);
        if (convertedNumber < START_NUMBER || END_NUMBER < convertedNumber) {
            errorMessage.illegalNumberRangeMessage();
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplication(List<Integer> convertedNumbers) {
        List<Integer> checkingDuplication = convertedNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (checkingDuplication.size() != convertedNumbers.size()) {
            errorMessage.duplicateNumberMessage();
            throw new IllegalArgumentException();
        }
    }

}
