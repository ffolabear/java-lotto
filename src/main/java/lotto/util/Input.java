package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.MoneyValidation;
import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;

public class Input {

    MoneyValidation moneyValidation;
    LottoValidation numberValidation;
    List<Integer> winningNumbers;
    int userMoney;

    public Input() {
        this.moneyValidation = new MoneyValidation();
        this.numberValidation = new LottoValidation();
        this.winningNumbers = new ArrayList<>();
        this.userMoney = 0;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public int getLottoTicket() {
        return userMoney / 1000;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void inputUserMoney() {
        String inputMoney = Console.readLine();
        moneyValidation.validate(inputMoney);
        userMoney = moneyValidation.getMoney();
    }

    public void inputWinningNumbers() {
        String inputNumbers = Console.readLine();
        numberValidation.validate(inputNumbers);
        winningNumbers = numberValidation.getValidNumbers();
    }

}
