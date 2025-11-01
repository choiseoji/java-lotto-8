package lotto.controller;

import lotto.model.Lottos;
import lotto.model.generator.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Input input;
    private final Output output;

    public LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void play() {
        Lottos lottos = buyLotto();
    }

    private Lottos buyLotto() {
        int purchaseAmount = input.readPurchaseAmount();
        Lottos lottos = LottoGenerator.generateLottos(purchaseAmount);
        output.printLottosNumbers(lottos);

        return lottos;
    }
}
