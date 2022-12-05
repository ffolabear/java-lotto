package lotto.util;

import lotto.service.Lotto;
import lotto.view.LottoMessage;

import java.util.List;

public class Output {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoPurchaseMessage(long ticket) {
        System.out.printf((LottoMessage.PURCHASE_MESSAGE.getMessage()) + "%n", ticket);
    }

    public void printLotto(List<Lotto> purchasedLotto) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : purchasedLotto) {
            sb.append(lotto.getNumbers()).append("\n");
        }
        System.out.println(sb);
    }

}
