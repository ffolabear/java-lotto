package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.validation.LottoSetting.*;

public class PurchaseLotto {

    int ticket;
    List<List<Integer>> purchasedLotto;

    public PurchaseLotto(int ticket) {
        this.ticket = ticket;
        generateLottoList();
    }

    public List<List<Integer>> getPurchasedLottoList() {
        return purchasedLotto;
    }

    private void generateLottoList() {
        purchasedLotto = new ArrayList<>();
        while (ticket > 0) {
            Lotto lotto = new Lotto(
                    Randoms.pickUniqueNumbersInRange(START_NUMBER.getValue(), END_NUMBER.getValue(),
                            NUMBER_AMOUNT.getValue()));
            ticket--;
            purchasedLotto.add(lotto.getNumbers());
        }
    }

}
