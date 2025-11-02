package lotto.view;

import lotto.model.Lotto;
import lotto.dto.RankResult;
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

    public void printWinningStatistics(RankResult rankResult) {
        System.out.println("\n당첨 통계\n" + "---");

        rankResult.oneRankResults().forEach(r ->
                System.out.println(r.displayName() + " (" + formatPrize(r.prize()) + "원) - " + r.count() + "개")
        );

        System.out.println("총 수익률은 " + formatProfitRate(rankResult.profitRate()) + "%입니다.");
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    private String formatProfitRate(double rate) {
        return String.format("%,.1f", rate);
    }

    private void printLottoCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    private void printOneLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("[" + result + "]");
    }
}
