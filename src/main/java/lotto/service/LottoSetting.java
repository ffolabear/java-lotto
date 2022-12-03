package lotto.service;

public enum LottoSetting {

    MONEY_UNIT(1000),
    START_NUMBER(1),
    END_NUMBER(45),
    NUMBER_AMOUNT(6);

    private final int attribute;

    LottoSetting(int attribute) {
        this.attribute = attribute;
    }

    public int getAttribute() {
        return attribute;
    }
}
