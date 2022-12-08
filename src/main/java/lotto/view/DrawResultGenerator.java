package lotto.view;

import lotto.service.Rank;

import java.util.*;

public class DrawResultGenerator {

    private final Map<Rank, Integer> rankMap;

    public DrawResultGenerator(Map<Rank, Integer> rankMap) {
        this.rankMap = rankMap;
        System.out.println(rankMap);
        sortMap();
    }

    private void sortMap() {
        List<Rank> keySet = new ArrayList<>(rankMap.keySet());
        keySet.sort((o1, o2) -> o1.getRank() - o2.getRank());
        System.out.println(keySet);
    }


}
