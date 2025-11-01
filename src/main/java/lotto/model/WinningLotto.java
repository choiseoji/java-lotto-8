package lotto.model;

import java.util.List;

public class WinningLotto {
    List<Integer> numbers;
    int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = List.copyOf(numbers);
        this.bonusNumber = bonusNumber;
    }
}
