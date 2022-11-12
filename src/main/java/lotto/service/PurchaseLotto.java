package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {

    int ticket;
    List<List<Integer>> purchasedLotto;
    LottoGenerator lottoGenerator;

    public PurchaseLotto(int ticket) {
        this.ticket = ticket;
        lottoGenerator = new LottoGenerator();
        generateLottoList();
    }

    public List<List<Integer>> getPurchasedLottoList() {
        return purchasedLotto;
    }

    private void generateLottoList() {
        purchasedLotto = new ArrayList<>();
        while (ticket > 0) {
            purchasedLotto.add(generateLotto());
            ticket--;
        }
    }

    private List<Integer> generateLotto() {
        return lottoGenerator.generateLotto();
    }

}
