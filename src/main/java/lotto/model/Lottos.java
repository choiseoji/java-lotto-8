package lotto.model;

import lotto.Lotto;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos (List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public int count() {
        return this.lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }
}
