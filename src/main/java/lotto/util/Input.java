package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoSetting;
import lotto.validation.BonusNumberValidation;
import lotto.validation.CommonValidation;
import lotto.validation.MoneyValidation;
import lotto.validation.NumberValidation;

import java.util.ArrayList;
import java.util.List;

public class Input {

    CommonValidation commonValidation = new CommonValidation();

    public int inputMoney() {
        String money = Console.readLine();
        commonValidation.test(money);
        MoneyValidation moneyValidation = new MoneyValidation();
        moneyValidation.test(money);
        return convertToTicket(money);
    }

    public List<Integer> inputWinningNumber() {
        String numbers = Console.readLine();
        NumberValidation numberValidation = new NumberValidation();
        numberValidation.test(numbers);
        return convertToIntegerList(numbers);
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        String number = Console.readLine();
        commonValidation.test(number);
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation(winningNumbers);
        bonusNumberValidation.test(number);
        return convertToInteger(number);
    }

    private int convertToTicket(String money) {
        int convertedMoney = convertToInteger(money);
        return convertedMoney / LottoSetting.MONEY_UNIT.getAttribute();
    }

    private int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    private List<Integer> convertToIntegerList(String numbers) {
        String[] seperatedNumbers = numbers.split(",");
        List<Integer> convertedNumbers = new ArrayList<>();
        for (String number : seperatedNumbers) {
            convertedNumbers.add(convertToInteger(number));
        }
        return convertedNumbers;
    }

}
