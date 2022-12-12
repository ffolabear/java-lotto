package lotto.validation;

import lotto.view.LottoErrors;

public interface Predicate {

    void test(String input);

    String printError(LottoErrors lottoErrors);

    int convertToInteger(String input);

}
