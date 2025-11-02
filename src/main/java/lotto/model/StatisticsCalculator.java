package lotto.model;

import java.util.Map;

public class StatisticsCalculator {

    public static double getProfitRate(Map<Rank, Integer> rankCount, int lottoCount) {
        int totalPrize = calculateTotalPrize(rankCount);
        return calculateProfitRate(lottoCount, totalPrize);
    }

    private static int calculateTotalPrize(Map<Rank, Integer> rankCount) {
        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();

            totalPrize += rank.getPrize() * count;
        }

        return totalPrize;
    }

    private static double calculateProfitRate(int lottoCount, int totalPrize) {
        double rate = (double) totalPrize / (lottoCount * LottoInfo.price()) * 100;
        return Math.round(rate * 100) / 100.0;
    }
}
