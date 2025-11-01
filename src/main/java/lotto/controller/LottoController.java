package lotto.controller;

import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.model.generator.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

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
