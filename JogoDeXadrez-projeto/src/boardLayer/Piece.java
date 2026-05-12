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

    }

    public boolean possibleMove(Position position) {

    }

    public boolean isThereAnyPossibleMove() {

    }

    public Position getPosition() {
        return position;
    }
}
