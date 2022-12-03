package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoSetting;
import lotto.validation.MoneyValidation;
import lotto.validation.NumberValidation;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public long InputMoney() {
        String money = Console.readLine();
        MoneyValidation moneyValidation = new MoneyValidation();
        moneyValidation.test(money);
        return convertToTicket(money);
    }

    public List<Integer> InputWinningNumber() {
        String numbers = Console.readLine();
        NumberValidation numberValidation = new NumberValidation();
        numberValidation.test(numbers);
        return convertToIntegerList(numbers);
    }

    public long convertToLong(String money) {
        return Long.parseLong(money);
    }

    public long convertToTicket(String money) {
        long convertedMoney = convertToLong(money);
        return convertedMoney / LottoSetting.MONEY_UNIT.getAttribute();
    }

    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> convertToIntegerList(String numbers) {
        String[] seperatedNumbers = numbers.split(",");
        List<Integer> convertedNumbers = new ArrayList<>();
        for (String number : seperatedNumbers) {
            convertedNumbers.add(convertToInteger(number));
        }
        return convertedNumbers;
    }

}
