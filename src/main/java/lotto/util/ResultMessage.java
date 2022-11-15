package lotto.util;

import lotto.service.CalculateYield;
import lotto.view.RankDetail;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.view.RankMessageDetail.*;

public class ResultMessage {

    CalculateYield calculateYield;
    Map<Integer, Integer> drawResult;
    StringBuilder resultMessage;
    int userMoney;
    int bonusMatched;
    boolean bonusResultTurn;

    public ResultMessage(Map<Integer, Integer> drawResult, int bonusMatched, int userMoney) {
        this.drawResult = drawResult;
        this.bonusMatched = bonusMatched;
        this.resultMessage = new StringBuilder();
        this.userMoney = userMoney;
        bonusResultTurn = false;
        createMessage();
    }

    private void createMessage() {
        createMessageHeader();
        createMessageBody();
        createYieldMessage();
    }

    public void printResultMessage() {
        System.out.println(resultMessage);
    }

    private void createMessageHeader() {
        StringBuilder messageHeader = new StringBuilder();
        messageHeader.append("\n");
        messageHeader.append(RESULT_TITLE.getMessage());
        messageHeader.append(RESULT_TITLE_LINE.getMessage());
        resultMessage.append(messageHeader);
    }

    private List<Integer> sortDrawResult() {
        return drawResult.keySet().stream().sorted().collect(Collectors.toList());
    }

    private String convertPrize(int prize) {
        DecimalFormat format = new DecimalFormat("###,###");
        return format.format(prize);
    }

    private void createMessageBody() {
        List<Integer> sortedResult = sortDrawResult();
        for (int matchAmount : sortedResult) {
            resultMessage.append(createMessageBodyLine(matchAmount));
        }
    }

    private String createMessageBodyLine(int matchAmount) {
        StringBuilder messageBody = new StringBuilder();
        for (RankDetail rank : RankDetail.values()) {
            if (matchAmount == rank.getMatchAmount()) {
                messageBody.append(createSingleMessageBodyLine(rank));
            }
        }
        return messageBody.toString();
    }

    private String createSingleMessageBodyLine(RankDetail rank) {
        String prize = convertPrize(rank.getPrize());
        if (rank.getMatchAmount() == RankDetail.BONUS.getMatchAmount()) {
            return createBonusMatchAmountMessageBodyLine(rank);
        }
        return String.format(MATCH_RESULT.getMessage(), rank.getMatchAmount(), "", prize,
                drawResult.get(rank.getMatchAmount())) + "\n";
    }

    private String createBonusMatchAmountMessageBodyLine(RankDetail rank) {
        String prize;
        if (bonusResultTurn) {
            prize = convertPrize(RankDetail.BONUS.getPrize());
            return String.format(MATCH_RESULT.getMessage(), rank.getMatchAmount(), BONUS_MATCHED.getMessage(),
                    prize, bonusMatched) + "\n";
        }
        bonusResultTurn = true;
        prize = convertPrize(RankDetail.SECOND.getPrize());
        return String.format(MATCH_RESULT.getMessage(), rank.getMatchAmount(), "", prize,
                drawResult.get(rank.getMatchAmount())) + "\n";
    }


    public void createYieldMessage() {
        calculateYield = new CalculateYield(drawResult, bonusMatched, userMoney);
        String yield = calculateYield.getYield();
        resultMessage.append(String.format(YIELD.getMessage(), yield));
    }


}
