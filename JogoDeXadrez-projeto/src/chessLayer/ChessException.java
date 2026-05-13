package chessLayer;

import java.io.Serial;

public class ChessException extends RuntimeException {
    @Serial
    private static final long serialUID = 1L;
    public ChessException(String message) {
        super(message);
    }
}
