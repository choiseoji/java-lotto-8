package lotto.validator;

import lotto.model.LottoInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
        if (amount % LottoInfo.price() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LottoInfo.price() + "원 단위여야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + LottoInfo.size() + "개여야 합니다.");
        }

        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != LottoInfo.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }

        for (int num : numbers) {
            validateBonusNumbers(num);
        }
    }

    public static void validateBonusNumbers(int number) {
        if (number < LottoInfo.min() || number > LottoInfo.max()) {
            throw new IllegalArgumentException("[ERROR] 번호는 " + LottoInfo.min() + " ~ " + LottoInfo.max() + " 사이여야 합니다.");
        }
    }
}
