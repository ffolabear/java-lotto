package lotto.view;

public enum RankMessageDetail {

    RESULT_TITLE("당첨 통계\n"),
    RESULT_TITLE_LINE("---\n"),
    BONUS_MATCHED(", 보너스 볼 일치"),
    MATCH_RESULT("%s개 일치%s (%s원) - %s개"),
    PROFIT_RATIO("총 수익률은 %s%%입니다.")
    ;

    private final String message;

    RankMessageDetail(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
