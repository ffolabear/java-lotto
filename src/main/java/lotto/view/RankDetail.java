package lotto.view;

public enum RankDetail {

    FIRST("first", 6, 2000000000),
    BONUS("bonus", 5, 30000000),
    SECOND("second", 5, 1500000),
    THIRD("third", 4, 50000),
    FOURTH("fourth", 3, 5000),
    ;

    private final String rank;
    private final int matchAmount;
    private final int prize;

    RankDetail(String rank, int matchAmount, int prize) {
        this.rank = rank;
        this.matchAmount = matchAmount;
        this.prize = prize;
    }

    public int getMatchAmount() {
        return matchAmount;
    }

    public int getPrize() {
        return prize;
    }

    public String getRank() {
        return rank;
    }
}
