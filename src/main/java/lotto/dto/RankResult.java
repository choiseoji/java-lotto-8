package lotto.dto;

import lotto.model.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record RankResult(
        List<OneRankResult> oneRankResults,
        double profitRate
) {

    public static RankResult toRankResult(Map<Rank, Integer> rankCount, double profitRate) {
        List<OneRankResult> rankResults = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            Integer count = rankCount.get(rank);
            rankResults.add(new OneRankResult(
                    rank.getDisplayName(),
                    rank.getPrize(),
                    count
            ));
        }
        return new RankResult(rankResults, profitRate);
    }
}
