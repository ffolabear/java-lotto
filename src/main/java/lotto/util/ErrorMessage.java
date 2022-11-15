package lotto.util;

import static lotto.view.ErrorDetail.*;

public class ErrorMessage {

    StringBuilder sb;

    public String illegalArgumentMessage() {
        sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_ILLEGAL_INPUT.getError());
        return sb.toString();
    }

    public String illegalNumberRangeMessage() {
        sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_RANGE.getError());
        return sb.toString();
    }

    public String illegalMoneyMessage() {
        sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_NON_DIVIDABLE.getError());
        return sb.toString();
    }

    public String negativeMoneyMessage() {
        sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_NEGATIVE_MONEY.getError());
        return sb.toString();
    }

    public static String illegalNumberAmountMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_NUMBER_AMOUNT.getError());
        return sb.toString();
    }

    public String illegalMoneyTypeMessage() {
        sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_NON_INTEGER.getError());
        return sb.toString();
    }

    public String duplicateNumberMessage() {
        sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_DUPLICATE_NUMBER.getError());
        return sb.toString();
    }

    public String duplicateBonusNumberMessage() {
        sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_DUPLICATE_BONUS_NUMBER.getError());
        return sb.toString();
    }

    public String insufficientMoneyMessage() {
        sb = new StringBuilder();
        sb.append(ERROR_HEAD.getError()).append(ERROR_INSUFFICIENT_MONEY.getError());
        return sb.toString();
    }
}
