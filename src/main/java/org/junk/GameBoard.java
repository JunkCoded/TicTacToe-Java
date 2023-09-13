package org.junk;

public class GameBoard {
    public int[] tableBoard = new int[9]; // 1 = x, 2 = o
    private char[][] visibleBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
    };

    public void PrintGameBoard() {
        Main.clearConsole();

        for (char[] row : visibleBoard) {
            for (char c : row) {
                System.out.print(c);
            }

            System.out.println();
        }
    }

    public void Place(int pos, boolean isX) {
        pos--;

        tableBoard[pos] = isX ? 1 : 2;
        visibleBoard[(pos / 3) * 2][(pos % 3) * 2] = isX ? 'x' : 'o';
    }

    public boolean isPosFree(int pos) {
        return tableBoard[pos - 1] == 0;
    }
}
