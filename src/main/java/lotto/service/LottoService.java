package lotto.service;

import lotto.util.Input;
import lotto.util.ResultMessage;
import lotto.util.SystemMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {

    SystemMessage message = new SystemMessage();
    Input input;
    LottoDraw lottoDraw;
    ResultMessage resultMessage;
    List<List<Integer>> generatedLotto;
    List<Integer> winningNumbers;
    int bonusNumber;

    public LottoService() {
        input = new Input();
        startService();
    }

    public void startService() {
        message.inputMoneyMessage();
        purchaseLotto();
        generateLotto(input.getLottoTicket());
        inputWinningNumbers();
        inputBonusNumber();
        draw();
        calculateYield();
    }

    private void purchaseLotto() {
        input.inputUserMoney();
        int ticket = input.getLottoTicket();
        message.purchaseResultMessage(ticket);
    }

    private void generateLotto(int ticket) {
        generatedLotto = new ArrayList<>();
        PurchaseLotto generateLotto = new PurchaseLotto(ticket);
        generatedLotto = generateLotto.getPurchasedLottoList();
        message.printGeneratedLotto(generatedLotto);
    }

    private void inputWinningNumbers() {
        winningNumbers = new ArrayList<>();
        message.inputWinningNumbersMessage();
        input.inputWinningNumbers();
        winningNumbers = input.getWinningNumbers();
    }

    private void inputBonusNumber() {
        bonusNumber = 0;
        message.inputBonusNumberMessage();
        input.inputBonusNumber(winningNumbers);
        bonusNumber = input.getBonusNumber();
    }

    private void draw() {
        lottoDraw = new LottoDraw(generatedLotto, winningNumbers, bonusNumber);
        lottoDraw.startDraw();
        Map<Integer, Integer> drawResult = lottoDraw.getDrawResult();
        int bonusMatched = lottoDraw.getBonusNumberMatched();
        createDrawResult(drawResult, bonusMatched);
    }

    private void createDrawResult(Map<Integer, Integer> drawResult, int bonusMatched) {
        resultMessage = new ResultMessage(drawResult, bonusMatched);
        resultMessage.printResultMessage();
    }

    private void calculateYield() {
        CalculateYield calculateYield = new CalculateYield(lottoDraw.getDrawResult(), lottoDraw.getBonusNumberMatched(),
                input.getUserMoney());
        resultMessage.printYieldMessage(calculateYield.getYield());
    }

}
