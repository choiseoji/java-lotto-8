package lotto.view;

import lotto.Lotto;
import lotto.dto.OneRankResult;
import lotto.dto.RankResult;
import lotto.model.Lottos;

import java.text.DecimalFormat;
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

        for (OneRankResult oneRankResult : rankResult.oneRankResults()) {
            String formattedPrize = String.format("%,d", oneRankResult.prize());

            System.out.println(
                    oneRankResult.displayName()
                            + " (" + formattedPrize + "원) - "
                            + oneRankResult.count() + "개"
            );
        }

        DecimalFormat df = new DecimalFormat("#,##0.0");
        String formattedRate = df.format(rankResult.profitRate());
        System.out.println("총 수익률은 " + formattedRate + "%입니다.");
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
