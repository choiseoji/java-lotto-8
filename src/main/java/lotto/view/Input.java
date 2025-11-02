package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;

public class Input {

    public int readPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");

            try {
                String input = Console.readLine();

                int purchaseAmount = toInt(input);
                LottoValidator.validateAmount(purchaseAmount);

                return purchaseAmount;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");

            try {
                String input = Console.readLine();

                List<Integer> numbers = parseNumbers(input);
                LottoValidator.validateNumbers(numbers);

                return numbers;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber() {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");

            try {
                String input = Console.readLine();

                int bonusNumber = toInt(input);
                LottoValidator.validateBonusNumbers(bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(this::toInt)
                .toList();
    }
}
