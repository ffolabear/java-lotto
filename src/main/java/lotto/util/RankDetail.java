package lotto.util;

public enum RankDetail {

    FIRST("6개 일치 (2,000,000,000원) - "),
    SECOND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SECOND("5개 일치 (1,500,000원) - "),
    THIRD("4개 일치 (50,000원) - "),
    FOURTH("3개 일치 (5,000원) - "),
    UNIT("개\n")
    ;

    private final String rankMessage;

    RankDetail(String rankMessage) {
        this.rankMessage = rankMessage;
    }

    public String getRankMessage() {
        return rankMessage;
    }
}
