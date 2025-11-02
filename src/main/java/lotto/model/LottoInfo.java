package lotto.model;

public enum LottoInfo {

    SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    PRICE(1000);

    private final int value;

    LottoInfo(int value) {
        this.value = value;
    }

    public static int size() {
        return SIZE.value;
    }

    public static int min() {
        return MIN_NUMBER.value;
    }

    public static int max() {
        return MAX_NUMBER.value;
    }

    public static int price() {
        return PRICE.value;
    }
}
