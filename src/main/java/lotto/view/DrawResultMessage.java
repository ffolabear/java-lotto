package lotto.view;

import lotto.service.Rank;

import java.text.DecimalFormat;

public enum DrawResultMessage {

    WITHOUT_BONUS("%s개 일치 (%s원) - %s개"),
    WITH_BONUS("%s개 일치, 보너스 볼 일치 (%s원) - %s개");

    private final String message;

    DrawResultMessage(String message) {
        this.message = message;
    }

    public String getMessage(Rank rank, int drawResult) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return String.format(message, rank.getMatchAmount(), decimalFormat.format(rank.getPrize()), drawResult);
    }
}
