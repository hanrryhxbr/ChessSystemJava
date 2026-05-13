package application;

import boardLayer.Board;
import chessLayer.ChessException;
import chessLayer.ChessMatch;
import chessLayer.ChessPiece;
import chessLayer.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    void main() {

        Scanner input = new Scanner(System.in);
        ChessMatch match = new ChessMatch();
        while (true) {
            try {
                    UI.clearScreen();
                    UI.printBoard(match.getPieces());
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(input);

                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(input);

                    ChessPiece capturedPiece = match.performChessMove(source, target);
            }
            catch (ChessException e) {
                IO.println(e.getMessage());
                input.nextLine();
            }
            catch (InputMismatchException e) {
                IO.println(e.getMessage());
                input.nextLine();
            }
        }
    }
}
