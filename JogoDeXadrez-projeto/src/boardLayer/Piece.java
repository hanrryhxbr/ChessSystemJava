package boardLayer;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    protected Piece[][] possibleMoves() {
        return null;
    }

    protected boolean possibleMove(Position position) {
        return false;
    }

    protected boolean isThereAnyPossibleMove() {
        return false;
    }

    public Position getPosition() {
        return position;
    }
}
