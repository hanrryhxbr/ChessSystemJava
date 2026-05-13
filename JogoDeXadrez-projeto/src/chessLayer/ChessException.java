package chessLayer;

import boardLayer.BoardException;

import java.io.Serial;

public class ChessException extends BoardException {
    @Serial
    private static final long serialUID = 1L;
    public ChessException(String message) {
        super(message);
    }
}
