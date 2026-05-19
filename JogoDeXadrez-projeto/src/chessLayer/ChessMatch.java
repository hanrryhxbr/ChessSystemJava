package chessLayer;

import boardLayer.Board;
import boardLayer.Piece;
import boardLayer.Position;
import chessLayer.pieces.King;
import chessLayer.pieces.Rook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {

    private final Board board;
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private List<ChessPiece> piecesOntheBoard = new ArrayList<>();
    private List<ChessPiece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        check = false;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] match = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                match[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return match;
    }

    public boolean isCheck() {
        return check;
    }

    private Color opponent(Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece king(Color color) {
        List<Piece> list = piecesOntheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color).collect(Collectors.toList());
        for (Piece p : list) {
            if (p instanceof King) {
                return (ChessPiece) p;
            }
        }
        throw new IllegalStateException("There is no " + color + "king on the board");
    }

    private boolean testCheck(Color color) {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> list = piecesOntheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == opponent(color)).collect(Collectors.toList());
        for (Piece p : list) {
            boolean[][] possibleMoves = p.possibleMoves();
            if (possibleMoves[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }
        return false;
    }

    public void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOntheBoard.add(piece);
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        if (testCheck(currentPlayer)) {
            undoMove(source, target, capturedPiece);
            throw new ChessException("You cannot put yourself in check");
        }
        check = testCheck(opponent(currentPlayer));
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

    public void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece in source position");
        }
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece is not yours");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There are no possible moves for the chosen piece");
        }
    }

    public void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece cannot move to the target position");
        }
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        if (target != null) {
            piecesOntheBoard.remove(capturedPiece);
            capturedPieces.add((ChessPiece) capturedPiece);
        }
        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece) {
        Piece p = board.removePiece(target);
        board.placePiece(p, source);

        if (capturedPiece != null) {
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOntheBoard.add((ChessPiece) capturedPiece);
        }
    }
}
