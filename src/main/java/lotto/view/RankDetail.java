package lotto.view;

public enum RankDetail {

    FIRST(6, 2000000000, 1),
    SECOND_BONUS(5, 30000000, 2),
    SECOND(5, 1500000, 3),
    THIRD(4, 50000, 4),
    FOURTH(3, 5000, 5),
    ;

    private final int matchAmount;
    private final int prize;
    private final int rank;

    RankDetail(int matchAmount, int prize, int rank) {
        this.matchAmount = matchAmount;
        this.prize = prize;
        this.rank = rank;
    }

    public int getMatchAmount() {
        return matchAmount;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }
}
