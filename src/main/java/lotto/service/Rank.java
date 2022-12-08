package lotto.service;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000);

    private final int rank;
    private final int matchAmount;
    private final int prize;

    Rank(int rank, int match, int prize) {
        this.rank = rank;
        this.matchAmount = match;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchAmount() {
        return matchAmount;
    }

    public int getPrize() {
        return prize;
    }

    public static Map<Rank, Integer> makeRankMap() {
        Rank[] ranks = Rank.values();
        Map<Rank, Integer> rankMap = new HashMap<>();
        for (Rank rank : ranks) {
            rankMap.put(rank, 0);
        }
        return rankMap;
    }

}
