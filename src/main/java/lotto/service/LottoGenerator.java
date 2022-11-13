package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LottoSetting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

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
        generatedLotto = Randoms.pickUniqueNumbersInRange(
                LottoSetting.START_NUMBER.getValue(),
                LottoSetting.END_NUMBER.getValue(),
                LottoSetting.NUMBER_AMOUNT.getValue());
    }

    private void sortNumbers() {
        Collections.sort(generatedLotto);
    }

}
