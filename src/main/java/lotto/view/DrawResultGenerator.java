package lotto.view;

import lotto.service.CalculateYield;
import lotto.service.Rank;

import java.util.*;

public class DrawResultGenerator {

    private final Map<Rank, Integer> drawResult;
    private List<Rank> keySet;
    private int money;

    public DrawResultGenerator(Map<Rank, Integer> drawResult, int money) {
        this.drawResult = drawResult;
        this.money = money;
        sortMap();
    }

    private void sortMap() {
        keySet = new ArrayList<>(drawResult.keySet());
        keySet.sort((o1, o2) -> o1.getRank() - o2.getRank());

    }

    public void generateResultMessage() {
        System.out.println(LottoMessage.RESULT_MESSAGE_HEADER.getMessage());
        System.out.println(LottoMessage.RESULT_MESSAGE_BORDER.getMessage());
        for (Rank rank : keySet) {
            printResultMessage(rank);
        }
        calculateYield(drawResult, money);
    }

    public void printResultMessage(Rank rank) {
        System.out.println(checkRank(rank));

    }

    private String checkRank(Rank rank) {
        if (rank == Rank.SECOND) {
            return bonusResultMessage(rank);
        }
        return normalResultMessage(rank);
    }

    private String normalResultMessage(Rank rank) {
        return DrawResultMessage.WITHOUT_BONUS.getMessage(rank, drawResult.get(rank));
    }

    private String bonusResultMessage(Rank rank) {
        return DrawResultMessage.WITH_BONUS.getMessage(rank, drawResult.get(rank));
    }

    private void calculateYield(Map<Rank, Integer> drawResult, int money) {
        CalculateYield calculateYield = new CalculateYield(drawResult, money);
        calculateYield.calculate();
    }

}
