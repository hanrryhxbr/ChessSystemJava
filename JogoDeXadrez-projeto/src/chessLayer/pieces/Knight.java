package chessLayer.pieces;

import boardLayer.Board;
import boardLayer.Position;
import chessLayer.ChessPiece;
import chessLayer.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] aux = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);


        //Above-right
        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            aux[p.getRow()][p.getColumn()] = true;
        }

        //Above-left
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            aux[p.getRow()][p.getColumn()] = true;
        }

        //Left-up
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            aux[p.getRow()][p.getColumn()] = true;
        }

        //Left-down
        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            aux[p.getRow()][p.getColumn()] = true;
        }

        //Below-left
        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            aux[p.getRow()][p.getColumn()] = true;
        }

        //Below-right
        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            aux[p.getRow()][p.getColumn()] = true;
        }

        //Right-down
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            aux[p.getRow()][p.getColumn()] = true;
        }

        //Right-up
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            aux[p.getRow()][p.getColumn()] = true;
        }
        return aux;
    }
}
