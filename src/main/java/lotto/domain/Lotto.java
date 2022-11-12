package lotto.domain;

import lotto.util.ErrorMessage;
import lotto.validation.LottoValidation;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        LottoValidation lottoValidation = new LottoValidation();
        lottoValidation.checkDuplication(numbers);
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
