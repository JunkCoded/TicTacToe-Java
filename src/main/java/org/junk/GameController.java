package org.junk;

import java.util.Scanner;

public class GameController {
    private boolean botMode; // Bot make O moves
    private boolean isMoveX;
    private int movesLeft = 9;
    private final GameBoard gameBoard = new GameBoard();

    private final int[][] winLines = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // horizontal
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // vertical
            {0, 4, 8}, {2, 4, 6} // cross lines
    };

    public void Start(int mode) {
        botMode = mode == 2;
        isMoveX = Math.random() > 0.5;
        gameBoard.PrintGameBoard();
        NewMove();
    }

    private void NewMove() {
        if (botMode && !isMoveX) {
            MakeMove(Main.getRandomNumber(1, 9));
            return;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Move: " + (isMoveX ? "X" : "O"));
        System.out.print("Your move (1-9): ");
        int newMove = scan.nextInt();
        MakeMove(newMove);
    }

    private void MakeMove(int id) {
        if (id < 1 || id > 9) {
            System.out.println("Invalid position!");
            NewMove();
            return;
        }

        if (!gameBoard.isPosFree(id)) {
            System.out.println("This position has already been!");
            NewMove();
            return;
        }

        gameBoard.Place(id, isMoveX);
        gameBoard.PrintGameBoard();

        boolean hasWinner = CheckWin();
        if (hasWinner) return;

        movesLeft--;
        if (movesLeft <= 0 ) {
            System.out.println("Game end!\nDraw!");
            return;
        }

        isMoveX = !isMoveX;
        NewMove();
    }

    private boolean CheckWin() {
        for (int[] line: winLines) {
            if (gameBoard.tableBoard[line[0]] == 1 && gameBoard.tableBoard[line[1]] == 1 && gameBoard.tableBoard[line[2]] == 1) {
                Win(true);
                return true;
            }

            if (gameBoard.tableBoard[line[0]] == 2 && gameBoard.tableBoard[line[1]] == 2 && gameBoard.tableBoard[line[2]] == 2) {
                Win(false);
                return true;
            }
        }

        return false;
    }

    private void Win(boolean isWinX) {
        System.out.println("Game end");
        System.out.println((isWinX ? "X" : "O") + " winner!");
    }
}
