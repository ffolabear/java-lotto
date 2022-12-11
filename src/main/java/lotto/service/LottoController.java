package lotto.service;

import lotto.util.Input;
import lotto.util.Output;
import lotto.view.LottoMessage;

import java.util.List;

public class LottoController {

    private final Output output = new Output();
    private final Input input = new Input();
    private List<Lotto> purchasedLotto;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int money;

    public void startLotto() {
        output.printMessage(LottoMessage.START_MESSAGE.getMessage());
        money = input.inputMoney();
        purchaseLotto(input.convertToTicket(money));
        setWinningNumber();
        setBonusNumber();
        drawLotto(purchasedLotto, winningNumbers);
    }

    public void purchaseLotto(long ticket) {
        output.printLottoPurchaseMessage(ticket);
        PurchaseLotto purchaseLotto = new PurchaseLotto(ticket);
        purchaseLotto.purchase();
        purchasedLotto = purchaseLotto.getPurchasedLotto();
        output.printLotto(purchasedLotto);
    }

    public void setWinningNumber() {
        output.printMessage(LottoMessage.WINNING_NUMBER_MESSAGE.getMessage());
        winningNumbers = input.inputWinningNumber();
    }

    public void setBonusNumber() {
        output.printMessage(LottoMessage.BONUS_NUMBER_MESSAGE.getMessage());
        bonusNumber = input.inputBonusNumber(winningNumbers);
    }

    public void drawLotto(List<Lotto> purchasedLotto, List<Integer> winningNumbers) {
        Draw draw = new Draw(purchasedLotto, winningNumbers, bonusNumber);
        draw.startDraw();
        draw.generateDrawResultMessage(money);
    }

    public void calculateYield() {

    }

}
