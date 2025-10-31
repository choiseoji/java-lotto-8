package lotto.validator;

import lotto.exception.LottoException;

public class LottoValidator {

    private static final int LOTTO_UNIT = 1000;

    public static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new LottoException("구입 금액은 양수여야 합니다.");
        }
        if (amount % LOTTO_UNIT != 0) {
            throw new LottoException("구입 금액은 " + LOTTO_UNIT + "원 단위여야 합니다.");
        }
    }
}
