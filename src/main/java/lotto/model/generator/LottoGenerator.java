package lotto.model.generator;

import lotto.Lotto;
import lotto.model.LottoInfo;
import lotto.model.Lottos;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public static Lottos generateLottos(int purchaseAmount) {
        int size = purchaseAmount / LottoInfo.price();

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < size; i++) {

            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoInfo.min(), LottoInfo.max(), LottoInfo.size())
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }
}
