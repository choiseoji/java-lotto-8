package lotto.controller;

import lotto.dto.RankResult;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.StatisticsCalculator;
import lotto.model.WinningLotto;
import lotto.model.generator.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final Input input;
    private final Output output;

    public LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void play() {
        Lottos lottos = buyLotto();
        WinningLotto winningLotto = getWinningLotto();

        Map<Rank, Integer> rankCount = lottos.getRankCount(winningLotto);
        double profitRate = StatisticsCalculator.getProfitRate(rankCount, lottos.count());

        RankResult rankResult = RankResult.toRankResult(rankCount, profitRate);
        output.printWinningStatistics(rankResult);
    }

    private Lottos buyLotto() {
        int purchaseAmount = input.readPurchaseAmount();
        Lottos lottos = LottoGenerator.generateLottos(purchaseAmount);
        output.printLottosNumbers(lottos);

        return lottos;
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = input.readWinningNumbers();
        int bonusNumber = input.readBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
