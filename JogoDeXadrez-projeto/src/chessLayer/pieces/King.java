package chessLayer.pieces;

import boardLayer.Board;
import chessLayer.ChessPiece;
import chessLayer.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] aux = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return aux;
    }
}
