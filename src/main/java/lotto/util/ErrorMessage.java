package lotto.util;

import lotto.view.ErrorDetail;

public class ErrorMessage {

    StringBuilder sb;

    public void illegalArgumentMessage() {
        sb = new StringBuilder();
        sb.append(ErrorDetail.ERROR_HEAD.getError())
                .append(ErrorDetail.ERROR_ILLEGAL_INPUT.getError());
        System.out.println(sb);
    }

    public void illegalNumberRangeMessage() {
        sb = new StringBuilder();
        sb.append(ErrorDetail.ERROR_HEAD.getError())
                .append(ErrorDetail.ERROR_RANGE.getError());
        System.out.println(sb);
    }

    public void illegalMoneyMessage() {
        sb = new StringBuilder();
        sb.append(ErrorDetail.ERROR_HEAD.getError())
                .append(ErrorDetail.ERROR_NON_DIVIDABLE.getError());
        System.out.println(sb);
    }

    public static void illegalNumberAmountMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(ErrorDetail.ERROR_HEAD.getError())
                .append(ErrorDetail.ERROR_NUMBER_AMOUNT.getError());
        System.out.println(sb);
    }

    public void illegalNumberFormatMessage() {
        sb = new StringBuilder();
        sb.append(ErrorDetail.ERROR_HEAD.getError())
                .append(ErrorDetail.ERROR_NUMBER_COMMA.getError());
        System.out.println(sb);
    }

    public void illegalMoneyTypeMessage() {
        sb = new StringBuilder();
        sb.append(ErrorDetail.ERROR_HEAD.getError())
                .append(ErrorDetail.ERROR_NON_INTEGER.getError());
        System.out.println(sb);
    }

    public void duplicateNumberMessage() {
        sb = new StringBuilder();
        sb.append(ErrorDetail.ERROR_HEAD.getError())
                .append(ErrorDetail.ERROR_DUPLICATE_NUMBER.getError());
        System.out.println(sb);
    }

}
