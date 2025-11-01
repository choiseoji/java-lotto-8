package lotto.view;

import lotto.Lotto;
import lotto.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public void printLottosNumbers(Lottos lottos) {
        int lottoCount = lottos.count();
        printLottoCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            printOneLottoNumbers(lottos.getLotto(i));
        }
    }

    private void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    private void printOneLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("[" + result + "]");
    }
}
