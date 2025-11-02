package lotto;

import lotto.model.Rank;
import lotto.model.StatisticsCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsCalculatorTest {

    @Test
    @DisplayName("10개를 구매해 1등 1개가 당첨되면 수익률 20000000.0을 반환한다")
    void 수익률을_정확하게_계산한다() {
        // given
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        rankCount.put(Rank.FIRST, 1);
        rankCount.put(Rank.SECOND, 0);
        rankCount.put(Rank.THIRD, 0);
        rankCount.put(Rank.FOURTH, 0);
        rankCount.put(Rank.FIFTH, 0);

        int lottoCount = 10;

        // when
        double profitRate = StatisticsCalculator.getProfitRate(rankCount, lottoCount);

        // then
        double expected = 20000000.0;
        assertEquals(expected, profitRate);
    }

    @Test
    void 모든_로또가_당첨되지_않으면_수익률_0을_반환한다() {
        // given
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
        int lottoCount = 5;

        // when
        double profitRate = StatisticsCalculator.getProfitRate(rankCount, lottoCount);

        // then
        assertEquals(0.0, profitRate);
    }
}
