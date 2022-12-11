package lotto.service;

import java.text.DecimalFormat;
import java.util.Map;

public class CalculateYield {

    private final Map<Rank, Integer> drawResult;
    private final String yieldMessage = "총 수익률은 %s%%입니다.";
    private final int money;

    public CalculateYield(Map<Rank, Integer> drawResult, int money) {
        this.drawResult = drawResult;
        this.money = money;
    }

    public String calculate() {
        int totalPrize = calculateTotalSum();
        double yield = (totalPrize / (double) money) * 100;
        double roundedYield = (Math.round(yield * 10) / 10.0);
        return String.format(yieldMessage, convertFormat(roundedYield));
    }

    private String convertFormat(double roundedYield) {
        if (String.valueOf(roundedYield).length() >= 6) {
            DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
            return decimalFormat.format(roundedYield);
        }
        return String.valueOf(roundedYield);
    }

    private int calculateTotalSum() {
        int totalPrize = 0;
        for (Rank rank : drawResult.keySet()) {
            totalPrize += getPrize(rank);
        }
        return totalPrize;
    }

    private int getPrize(Rank rank) {
        if (drawResult.get(rank) > 0) {
            return rank.getPrize();
        }
        return 0;
    }

}
