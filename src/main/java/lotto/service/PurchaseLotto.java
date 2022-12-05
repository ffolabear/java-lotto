package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {

    private long ticket;
    private final List<Lotto> purchasedLotto;

    public PurchaseLotto(long ticket) {
        this.ticket = ticket;
        purchasedLotto = new ArrayList<>();
    }

    public void purchase() {
        NumberGenerator numberGenerator = new NumberGenerator();
        while (ticket > 0) {
            Lotto lotto = new Lotto(numberGenerator.generateNumber());
            purchasedLotto.add(lotto);
            ticket--;
        }
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
