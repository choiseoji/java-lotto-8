package lotto.validator;

import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException("당첨 번호는 6개여야 합니다.");
        }

        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != 6) {
            throw new LottoException("중복된 번호가 있습니다.");
        }

        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new LottoException("번호는 1 ~ 45 사이여야 합니다.");
            }
        }
    }

    public static void validateBonusNumbers(int number) {
        if (number < 1 || number > 45) {
            throw new LottoException("번호는 1 ~ 45 사이여야 합니다.");
        }
    }
}
