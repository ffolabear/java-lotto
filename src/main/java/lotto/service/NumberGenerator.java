package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoSetting.START_NUMBER.getAttribute(),
                LottoSetting.END_NUMBER.getAttribute(), LottoSetting.NUMBER_AMOUNT.getAttribute());
    }

}
