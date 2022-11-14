package lotto.view;

public enum RankDetail {

    FIRST(6, 2000000000),
    SECOND_BONUS(5, 30000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ;

    private final int matchAmount;
    private final int prize;

    RankDetail(int matchAmount, int prize) {
        this.matchAmount = matchAmount;
        this.prize = prize;
    }

    public int getMatchAmount() {
        return matchAmount;
    }

    public int getPrize() {
        return prize;
    }

}
