package lotto.util;

import java.io.BufferedReader;

public class Message {

    public void inputMoneyMessage() {
        System.out.println(MessageDetail.INPUT_MONEY.getMessage());
    }

    public void purchaseResultMessage(int ticket) {
        System.out.println(ticket + MessageDetail.PURCHASE_RESULT.getMessage());
    }

    public void inputBonusNumberMessage() {
        System.out.println(MessageDetail.INPUT_BONUS_NUMBER);
    }

    public void drawResultMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(MessageDetail.RESULT_TITLE.getMessage());
        sb.append(MessageDetail.RESULT_TITLE_LINE.getMessage());

    }

    public String firstPlaceMessage(int matchCount) {
        return RankDetail.FIRST.getRankMessage() + matchCount + RankDetail.UNIT.getRankMessage();
    }

    public String secondWithBonusPlaceMessage(int matchCount) {
        return RankDetail.SECOND_BONUS.getRankMessage() + matchCount + RankDetail.UNIT.getRankMessage();
    }

    public String secondPlaceMessage(int matchCount) {
        return RankDetail.SECOND.getRankMessage() + matchCount + RankDetail.UNIT.getRankMessage();
    }

    public String thirdPlaceMessage(int matchCount) {
        return RankDetail.THIRD.getRankMessage() + matchCount + RankDetail.UNIT.getRankMessage();
    }

    public String fourthPlaceMessage(int matchCount) {
        return RankDetail.FOURTH.getRankMessage() + matchCount + RankDetail.UNIT.getRankMessage();
    }
}
