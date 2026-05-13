package application;

import boardLayer.Board;
import chessLayer.ChessMatch;

public class Program {
    void main() {

        ChessMatch match = new ChessMatch();
        UI.printBoard(match.getPieces());
    }
}
