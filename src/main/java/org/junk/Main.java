package org.junk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.Start(requestGamemode());
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int requestGamemode() {
        System.out.println("Available modes:");
        System.out.println("\t1 - Player vs Player");
        System.out.println("\t2 - Player vs Bot");
        System.out.print("Select mode - ");

        Scanner scan = new Scanner(System.in);
        int mode = scan.nextInt();

        if (mode < 1 || mode > 2) {
            clearConsole();
            System.out.println("Unavailable mode!");
            return requestGamemode();
        }

        return mode;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}