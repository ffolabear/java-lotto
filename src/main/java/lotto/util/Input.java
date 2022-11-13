package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.*;

import java.util.ArrayList;
import java.util.List;

public class Input {

    List<Integer> winningNumbers;
    int userMoney;
    int ticket;
    int bonusNumber;


    public Input() {
        this.winningNumbers = new ArrayList<>();
        this.userMoney = 0;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public int getLottoTicket() {
        return ticket;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void inputUserMoney() {
        String inputMoney = Console.readLine();
        MoneyValidation validation = new MoneyValidation(inputMoney);
        validation.validate(inputMoney);
        userMoney = validation.getMoney();
        ticket = validation.getTicket();
    }

    public void inputWinningNumbers() {
        String inputNumbers = Console.readLine();
        WinningNumberValidation validation = new WinningNumberValidation();
        validation.validate(inputNumbers);
        winningNumbers = validation.getValidatedWinningNumber();
    }

    public void inputBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = Console.readLine();
        BonusNumberValidation validation = new BonusNumberValidation(winningNumbers, inputBonusNumber);
        validation.validate();
        bonusNumber = validation.getValidatedBonusNumber();
    }

}
