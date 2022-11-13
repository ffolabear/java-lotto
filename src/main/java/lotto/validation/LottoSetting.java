package lotto.validation;

public enum LottoSetting {

    START_NUMBER(1), END_NUMBER(45), NUMBER_AMOUNT(6);

    private final int value;

    LottoSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
