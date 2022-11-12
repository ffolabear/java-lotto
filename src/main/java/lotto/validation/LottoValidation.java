package lotto.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidation implements InputValidation {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int NUMBER_AMOUNT = 6;
    List<Integer> convertedNumbers;

    public void validate(String numbers) {
        List<String> rawNumbers = convertToStringNumberList(numbers);
//        isValidAmount(rawNumbers);
        convertedNumbers = convertToIntegerNumberList(rawNumbers);
        checkDuplication();
    }

    @Override
    public void isInputInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
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
            isInputInteger(number);
            isValidRange(number);
            convertedNumbers.add(convertToInteger(number));
        }
        return convertedNumbers;
    }

//    private void isValidAmount(List<String> rawNumbers) {
//        if (rawNumbers.size() != 6) {
//            throw new IllegalArgumentException();
//        }
//    }

    private void isValidRange(String number) {
        int convertedNumber = Integer.parseInt(number);
        if (convertedNumber < START_NUMBER || END_NUMBER < convertedNumber) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplication() {
        List<Integer> checkingDuplication = convertedNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (checkingDuplication.size() != convertedNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

}
