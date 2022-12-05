package lotto.service;

import java.util.List;

public class Draw {

    private final List<Lotto> purchasedLotto;
    private final List<Integer> winningNumbers;

    public Draw(List<Lotto> purchasedLotto, List<Integer> winningNumbers) {
        this.purchasedLotto = purchasedLotto;
        this.winningNumbers = winningNumbers;
    }

    public void startDraw() {
        for (Lotto lotto : purchasedLotto) {
            drawLotto(lotto);
        }
    }

    public void drawLotto(Lotto lotto) {

    }

}
