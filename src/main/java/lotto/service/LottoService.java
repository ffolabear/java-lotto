package lotto.service;

import lotto.util.Input;

import java.util.List;

public class LottoService {

    Input input;
    List<List<Integer>> purchasedLotto;

    public LottoService() {
        input = new Input();
        purchaseLotto();
    }


    public void purchaseLotto() {
        input.inputUserMoney();
        int ticket = input.getLottoTicket();
        PurchaseLotto purchaseLotto = new PurchaseLotto(ticket);
        purchasedLotto = purchaseLotto.getPurchasedLottoList();
        System.out.println(purchasedLotto);
    }

}
