package lotto.domain;

import lotto.util.ErrorMessage;
import lotto.validation.WinningNumberValidation;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        WinningNumberValidation validation = new WinningNumberValidation();
        validation.checkDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorMessage.illegalNumberAmountMessage();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현


}
