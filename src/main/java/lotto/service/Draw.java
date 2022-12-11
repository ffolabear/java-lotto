package lotto.service;

import lotto.view.DrawResultGenerator;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Draw {

    private final List<Lotto> purchasedLotto;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Rank, Integer> drawResult;

    public Draw(List<Lotto> purchasedLotto, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLotto = purchasedLotto;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        drawResult = Rank.makeRankMap();
    }

    public void startDraw() {
        for (Lotto lotto : purchasedLotto) {
            int matchCount = drawLotto(lotto);
            boolean isBonusMatched = drawBonus(lotto, matchCount);
            if (matchCount > 0) {
                makeDrawResult(matchCount, isBonusMatched);
            }
        }
    }

    private void makeDrawResult(int matchCount, boolean isBonusMatched) {
        if (isBonusMatched) {
            addBonusResult();
            return;
        }
        for (Rank rank : Rank.values()) {
            if (rank.getMatchAmount() == matchCount && rank.getRank() != Rank.SECOND.getRank()) {
                drawResult.put(rank, drawResult.getOrDefault(rank, 0) + 1);
            }

        }
    }

    private void addBonusResult() {
        drawResult.put(Rank.SECOND, drawResult.get(Rank.SECOND) + 1);
    }


    private int drawLotto(Lotto lotto) {
        List<Integer> generatedNumbers = lotto.getNumbers();
        List<Integer> matchCheck = winningNumbers.stream().filter(
                number -> generatedNumbers.stream().anyMatch(Predicate.isEqual(number))).collect(Collectors.toList());
        if (matchCheck.size() >= 3) {
            return matchCheck.size();
        }
        return 0;
    }

    private boolean drawBonus(Lotto lotto, int matchCount) {
        if (matchCount > 0) {
            return lotto.getNumbers().contains(bonusNumber);
        }
        return false;
    }

    public void generateDrawResultMessage(int money) {
        DrawResultGenerator resultGenerator = new DrawResultGenerator(drawResult, money);
        resultGenerator.generateResultMessage();
    }



}
