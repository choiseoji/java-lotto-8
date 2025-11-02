package lotto;

import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        LottoValidator.validateNumbers(numbers);

        this.numbers = numbers;
    }

    public Rank matchRank(WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        int matchCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = numbers.contains(bonusNumber);

        return Rank.of(matchCount, bonusMatch);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
