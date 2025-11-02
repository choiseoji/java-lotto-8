package lotto;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 로또의_개수를_반환한다() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        // when
        int count = lottos.count();

        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 목록 중 1등 1개, 2등 1개, 나머지는 미당첨일 경우 등수별 개수를 반환한다.")
    void 등수별_로또_개수를_반환한다() {
        // given
        Lotto firstPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        Lottos lottos = new Lottos(List.of(firstPrizeLotto, secondPrizeLotto, lotto));

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        Map<Rank, Integer> rankCount = lottos.getRankCount(winningLotto);

        // then
        assertThat(rankCount.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCount.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCount.get(Rank.THIRD)).isEqualTo(0);
        assertThat(rankCount.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(rankCount.get(Rank.FIFTH)).isEqualTo(0);
    }
}
