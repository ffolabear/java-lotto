package lotto.service;

import lotto.util.Input;
import lotto.util.ResultMessage;
import lotto.util.SystemMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    Input input;
    SystemMessage message = new SystemMessage();
    List<List<Integer>> generatedLotto;
    List<Integer> winningNumbers;
    int bonusNumber;
    int ticket;

    public LottoService() {
        input = new Input();
        startService();
    }

    public void startService() {
        message.inputMoneyMessage();
        purchaseLotto();
        generateLotto(ticket);
        inputWinningNumbers();
        inputBonusNumber();
        startDraw();
    }

    private void purchaseLotto() {
        input.inputUserMoney();
        ticket = input.getLottoTicket();
        message.purchaseResultMessage(ticket);
    }

    private void generateLotto(int ticket) {
        generatedLotto = new ArrayList<>();
        GenerateLotto generateLotto = new GenerateLotto(ticket);
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

    private void startDraw() {
        LottoDraw lottoDraw = new LottoDraw(generatedLotto, winningNumbers, bonusNumber);
        lottoDraw.startDraw();
        Map<Integer, Integer> lottoResult = lottoDraw.getDrawResult();
        int bonusMatched = lottoDraw.getBonusNumberMatched();
//        ResultMessage resultMessage = new ResultMessage(lottoResult, bonusMatched);
        List<Integer> keyset = lottoResult.keySet().stream().sorted().collect(Collectors.toList());
        System.out.println("LottoService.startDraw : " + keyset);
    }

}
