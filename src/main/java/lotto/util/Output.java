package lotto.util;

import lotto.service.Lotto;
import lotto.view.LottoMessage;

import java.util.List;
import java.util.stream.Collectors;

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
            sb.append(lotto.getNumbers().stream().sorted().collect(Collectors.toList())).append(",").append("\n");
        }
        System.out.println(sb);
    }

}
