package lotto.model.generator;

import lotto.Lotto;
import lotto.model.Lottos;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_UNIT = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static Lottos generateLottos(int purchaseAmount) {
        int size = purchaseAmount / LOTTO_UNIT;

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < size; i++) {

            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }
}
