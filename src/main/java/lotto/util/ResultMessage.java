package lotto.util;

import lotto.view.MessageDetail;
import lotto.view.RankDetail;

public class ResultMessage {

    StringBuilder sb;

    public void drawResultMessage() {
        sb = new StringBuilder();
        sb.append("\n");
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
