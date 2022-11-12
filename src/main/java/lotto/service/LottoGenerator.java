package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    final int START_NUMBER = LottoValidation.START_NUMBER;
    final int END_NUMBER = LottoValidation.END_NUMBER;
    final int NUMBER_AMOUNT = LottoValidation.NUMBER_AMOUNT;

    List<Integer> generatedLotto;

    public List<Integer> generateLotto() {
        generateNumberList();
        sortNumbers();
        return generatedLotto;
    }

//    public int generateNumbers() {
//        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
//    }

    public void generateNumberList() {
        generatedLotto = new ArrayList<>();
        generatedLotto = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_AMOUNT);
    }

    private void sortNumbers() {
        Collections.sort(generatedLotto);
    }

}
