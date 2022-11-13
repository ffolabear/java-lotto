package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoDraw {

    List<List<Integer>> generatedLotto;
    List<Integer> winningNumbers;
    Map<Integer, Integer> lottoResult;
    int bonusNumber;
    int bonusNumberMatched;

    public LottoDraw(List<List<Integer>> generatedLotto, List<Integer> winningNumbers, int bonusNumber) {
        this.generatedLotto = generatedLotto;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoResult = new HashMap<>();
    }


    public Map<Integer, Integer> getDrawResult() {
        return lottoResult;
    }

    public int getBonusNumberMatched() {
        return bonusNumberMatched;
    }

    public void startDraw() {
        for (List<Integer> lotto : generatedLotto) {
            int matchAmount = draw(lotto);
            if (matchAmount >= 3) {
                generateResultMap(matchAmount);
            }
        }
    }

    private int draw(List<Integer> lotto) {
        List<Integer> matchNumbers = lotto.stream()
                .filter(number -> winningNumbers.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList());
        if (matchNumbers.size() == 5) {
            isBonusMatched(lotto);
        }
        return matchNumbers.size();
    }

    private void generateResultMap(int matchAmount) {
        lottoResult.put(matchAmount, lottoResult.getOrDefault(matchAmount, 0) + 1);
    }

    private void isBonusMatched(List<Integer> lotto) {
        if (lotto.contains(bonusNumber)) {
            bonusNumberMatched++;
        }
    }

}
