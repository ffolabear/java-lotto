package lotto.util;

import lotto.view.MessageDetail;

import java.util.List;

public class SystemMessage {

    StringBuilder sb;

    public void inputMoneyMessage() {
        System.out.println(MessageDetail.INPUT_MONEY.getMessage());
    }

    public void purchaseResultMessage(int ticket) {
        sb = new StringBuilder();
        sb.append("\n")
                .append(ticket)
                .append(MessageDetail.PURCHASE_RESULT.getMessage());
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
        System.out.println(MessageDetail.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void inputBonusNumberMessage() {
        sb = new StringBuilder();
        sb.append("\n").append(MessageDetail.INPUT_BONUS_NUMBER.getMessage());
        System.out.println(sb);
    }


}
