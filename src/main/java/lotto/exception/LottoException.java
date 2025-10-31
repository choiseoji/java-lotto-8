package lotto.exception;

public class LottoException extends RuntimeException{
    public LottoException(String message) {
        super("[ERROR] " + message);
    }
}
