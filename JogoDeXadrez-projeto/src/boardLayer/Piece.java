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

    public Piece[][] possibleMoves() {
        return null;
    }

    public boolean possibleMove(Position position) {
        return false;
    }

    public boolean isThereAnyPossibleMove() {
        return false;
    }

    public Position getPosition() {
        return position;
    }
}
