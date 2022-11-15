package lotto.service;

import lotto.view.RankDetail;

import java.math.BigDecimal;
import java.util.Map;

public class CalculateYield {

    Map<Integer, Integer> drawResult;
    int userMoney;
    int bonusMatched;
    int totalPrize;

    public CalculateYield(Map<Integer, Integer> drawResult, int bonusMatched, int userMoney) {
        this.drawResult = drawResult;
        this.userMoney = userMoney;
        this.bonusMatched = bonusMatched;
        calculate();
    }

    public String getYield() {
        double yield = ((double) totalPrize / (double) userMoney) * 100;
        yield = Math.round(yield * 100) / 100.0;
        String convertedYield = String.format("%.1f", yield);
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(convertedYield)).setScale(1);
        return String.valueOf(bigDecimal);
    }

    private void calculate() {
        for (int matchAmount : drawResult.keySet()) {
            totalPrize += wonPrize(drawResult.get(matchAmount), findMatchedRankPrize(matchAmount));
        }
    }

    private int wonPrize(int matchResult, int prize) {
        return matchResult * prize;
    }

    private int findMatchedRankPrize(int matchAmount) {
        int prize = 0;
        for (RankDetail rank : RankDetail.values()) {
            if (rank.getMatchAmount() == matchAmount) {
                prize = getPrize(rank);
            }
        }
        return prize;
    }

    private int getPrize(RankDetail rank) {
        if (rank.getRank().equals("bonus")) {
            return RankDetail.BONUS.getPrize();
        }
        return rank.getPrize();
    }


}
