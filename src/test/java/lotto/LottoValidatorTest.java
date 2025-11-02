package lotto;

import lotto.model.LottoInfo;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoValidatorTest {

    @Test
    void 금액이_0원_이하면_예외가_발생한다() {
        int invalidAmount = 0;

        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateAmount(invalidAmount));
    }

    @Test
    void 금액이_로또_가격의_배수가_아니면_예외가_발생한다() {
        int invalidAmount = LottoInfo.price() + 1;

        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateAmount(invalidAmount));
    }

    @Test
    void 로또_번호가_6개가_아니면_예외가_발생한다() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateNumbers(invalidNumbers));
    }

    @Test
    void 로또_번호에_중복이_있으면_예외가_발생한다() {
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 3, 4, 5);

        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateNumbers(duplicatedNumbers));
    }

    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 6);

        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateNumbers(outOfRangeNumbers));
    }

    @Test
    void 보너스_번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 6;

        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateBonusNumber(bonus, winningNumbers));
    }

    @Test
    void 모든_입력이_정상이라면_예외가_발생하지_않는다() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        int amount = LottoInfo.price() * 2;

        assertDoesNotThrow(() -> LottoValidator.validateAmount(amount));
        assertDoesNotThrow(() -> LottoValidator.validateNumbers(validNumbers));
        assertDoesNotThrow(() -> LottoValidator.validateBonusNumber(bonus, validNumbers));
    }

}
