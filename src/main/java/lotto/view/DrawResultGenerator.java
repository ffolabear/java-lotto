package lotto.view;

import lotto.service.Rank;

import java.util.*;

public class DrawResultGenerator {

    private final Map<Rank, Integer> rankMap;
    private List<Rank> keySet;

    public DrawResultGenerator(Map<Rank, Integer> rankMap) {
        this.rankMap = rankMap;
        sortMap();
    }

    private void sortMap() {
        keySet = new ArrayList<>(rankMap.keySet());
        keySet.sort((o1, o2) -> o1.getRank() - o2.getRank());

    }

    public void generateResultMessage() {
        System.out.println(LottoMessage.RESULT_MESSAGE_HEADER.getMessage());
        System.out.println(LottoMessage.RESULT_MESSAGE_BORDER.getMessage());
        for (Rank rank : keySet) {
            printResultMessage(rank);
        }
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

    private String  normalResultMessage(Rank rank) {
        return DrawResultMessage.WITHOUT_BONUS.getMessage(rank, rankMap.get(rank));
    }

    private String bonusResultMessage(Rank rank) {
        return DrawResultMessage.WITH_BONUS.getMessage(rank, rankMap.get(rank));
    }

}
