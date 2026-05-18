package application;

import boardLayer.Board;
import chessLayer.ChessException;
import chessLayer.ChessMatch;
import chessLayer.ChessPiece;
import chessLayer.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    void main() {

        Scanner input = new Scanner(System.in);
        ChessMatch match = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (true) {
            try {
                    UI.clearScreen();
                    UI.printMatch(match, captured);
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(input);

                    boolean[][] possibleMoves = match.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(match.getPieces(), possibleMoves);

                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(input);

                    ChessPiece capturedPiece = match.performChessMove(source, target);

                    if (capturedPiece != null) {
                        captured.add(capturedPiece);
                    }
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
