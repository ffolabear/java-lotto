package lotto.validation;

import lotto.view.LottoErrors;

public interface Predicate {

    void test(String input);
    void printError(LottoErrors lottoErrors);

}
