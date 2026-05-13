package application;

import chessLayer.ChessMatch;
import chessLayer.ChessPiece;

public class UI {
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            IO.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]);
            }
            IO.println();

        }
        IO.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            IO.print("-");
        } else {
            IO.print(piece);
        }
        IO.print(" ");
    }
}
