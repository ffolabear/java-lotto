package lotto.util;

import java.util.List;

import static lotto.view.MessageDetail.*;

public class SystemMessage {

    StringBuilder sb;

    public void inputMoneyMessage() {
        System.out.println(INPUT_MONEY.getMessage());
    }

    public void purchaseResultMessage(int ticket) {
        sb = new StringBuilder();
        sb.append("\n")
                .append(ticket)
                .append(PURCHASE_RESULT.getMessage());
        System.out.println(sb);
    }

    public void printGeneratedLotto(List<List<Integer>> generatedLotto) {
        sb = new StringBuilder();
        for (List<Integer> lotto : generatedLotto) {
            sb.append(lotto).append("\n");
        }
        System.out.println(sb);
    }

    public void inputWinningNumbersMessage() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
    }

    public void inputBonusNumberMessage() {
        sb = new StringBuilder();
        sb.append("\n").append(INPUT_BONUS_NUMBER.getMessage());
        System.out.println(sb);
    }


}
