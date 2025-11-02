package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_6개_일치하면_1등을_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        Rank rank = lotto.matchRank(winningLotto);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void 로또_번호가_5개_일치하고_보너스도_일치하면_2등을_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        Rank rank = lotto.matchRank(winningLotto);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 로또_번호가_5개_일치하면_3등을_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 8);

        // when
        Rank rank = lotto.matchRank(winningLotto);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 로또_번호가_4개_일치하면_4등을_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 8));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 8);

        // when
        Rank rank = lotto.matchRank(winningLotto);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 로또_번호가_3개_일치하면_5등을_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 9, 8));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 8);

        // when
        Rank rank = lotto.matchRank(winningLotto);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 일치하는_번호가_3개_미만이면_당첨되지_않는다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 7, 8, 9, 10), 8);

        // when
        Rank rank = lotto.matchRank(winningLotto);

        // then
        assertThat(rank).isEqualTo(null);
    }
}
