package lotto.util;

import lotto.view.RankDetail;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.view.RankMessageDetail.*;

public class ResultMessage {

    StringBuilder resultMessage;
    Map<Integer, Integer> drawResult;
    int bonusMatched;
    boolean bonusResultTurn;

    public ResultMessage(Map<Integer, Integer> drawResult, int bonusMatched) {
        this.drawResult = drawResult;
        this.bonusMatched = bonusMatched;
        this.resultMessage = new StringBuilder();
        bonusResultTurn = false;
        createMessage();
    }

    private void createMessage() {
        createMessageHeader();
        createMessageBody();
    }

    public void printResultMessage() {
        System.out.println(resultMessage);
    }

    private void createMessageBody() {
        List<Integer> sortedResult = sortDrawResult();
        for (int matchAmount : sortedResult) {
            resultMessage.append(createMessageBodyLine(matchAmount));
        }
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

    private String createMessageBodyLine(int matchAmount) {
        StringBuilder messageBody = new StringBuilder();
        for (RankDetail rank : RankDetail.values()) {
            if (matchAmount == rank.getMatchAmount()) {
                messageBody.append(makeLine(rank.getMatchAmount(), rank.getPrize()));
            }
        }
        return messageBody.toString();
    }


    private String makeLine(int matchAmount, int prize) {
        StringBuilder singleMessageBody = new StringBuilder();
        if (matchAmount == 5) {
            return makeLineWithBonus(matchAmount, prize);
        }
        singleMessageBody.append(
                String.format(MATCH_RESULT.getMessage(), matchAmount, "", convertPrize(prize),
                        drawResult.get(matchAmount))).append("\n");
        return singleMessageBody.toString();
    }

    private String makeLineWithBonus(int matchAmount, int prize) {
        if (bonusResultTurn) {
            return String.format(MATCH_RESULT.getMessage(), matchAmount, BONUS_MATCHED.getMessage(),
                    convertPrize(prize), bonusMatched) + "\n";
        }
        bonusResultTurn = true;
        return String.format(MATCH_RESULT.getMessage(), matchAmount, "", convertPrize(prize), bonusMatched) + "\n";
    }

}
