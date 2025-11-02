package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos (List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public Map<Rank, Integer> getRankCount(WinningLotto winningLotto) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }

        for(Lotto lotto : lottos) {
            Rank rank = lotto.matchRank(winningLotto);
            if (rank != null) {
                int prevCount = rankCount.get(rank);
                rankCount.put(rank, prevCount + 1);
            }
        }

        return rankCount;
    }

    public int count() {
        return this.lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }
}
