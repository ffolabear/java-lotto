package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.MoneyValidation;
import lotto.validation.NumberValidation;

import java.util.List;

public class Input {

    MoneyValidation moneyValidation;
    NumberValidation numberValidation;

    public Input() {
        this.numberValidation = new NumberValidation();
        this.numberValidation = new NumberValidation();
    }

    public int inputUserMoney() {
        String inputMoney = Console.readLine();
        return moneyValidation.validateMoney(inputMoney);
    }


    public List<Integer> inputLottoWinningNumbers() {
        List<String> inputLottoNumbers = List.of(Console.readLine().split(","));
        return numberValidation.validateNumbers(inputLottoNumbers);
    }

}
