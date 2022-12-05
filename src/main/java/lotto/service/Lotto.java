package lotto.service;

import lotto.validation.LottoValidation;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
        sortLotto();
    }

    private void validate(List<Integer> numbers) {
        LottoValidation lottoValidation = new LottoValidation(numbers);
        lottoValidation.validate();
    }

    // TODO: 추가 기능 구현
    private void sortLotto() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
