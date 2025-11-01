package lotto.model;


import lotto.Lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsCalculator {

    private long totalPrize;
    private Map<Rank, Integer> rankCount = new HashMap<>();

    public StatisticsCalculator() {
        this.totalPrize = 0;
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void calculateStatistics(Lottos lottos, WinningLotto winningLotto) {

        for(int i = 0; i < lottos.count(); i++) {
            Lotto lotto = lottos.getLotto(i);

            int numbersMatchCount = countMatchNumbers(lotto, winningLotto.getNumbers());
            int bonusMatchCount = countMatchBonus(lotto, winningLotto.getBonusNumber());

            Rank rank = getRank(numbersMatchCount, bonusMatchCount);
            if (rank == null)
                continue;

            int prevCount = rankCount.get(rank);
            rankCount.put(rank, prevCount + 1);

            totalPrize += rank.getPrize();
        }
    }

    public double getProfitRate(int amount) {
        double rate =  (double) totalPrize / (amount * 1000) * 100;
        return Math.round(rate * 100) / 100.0;
    }

    private int countMatchNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private int countMatchBonus(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus))
            return 1;
        return 0;
    }

    private Rank getRank(int numbersMatchCount, int bonusMatchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == numbersMatchCount)
                .filter(rank ->
                        rank.getMatchCount() != 5 || rank.getBonusMatchCount() == bonusMatchCount
                )
                .findFirst()
                .orElse(null);
    }

    public Map<Rank, Integer> getRankCount() {
        return this.rankCount;
    }
}
