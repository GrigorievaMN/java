package ru.geekbrains.courses.java.lesson4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainAppLesson4 {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void main(String[] args) {
        isSizeMoreThanTwo();
        initMap();
        System.out.printf("Игра крестики - нолики!\nДля победы поставь %d фишки\n", DOTS_TO_WIN);
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (isWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (isWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
        sc.close();

    }

    public static boolean isWin(char symbol) {
        //Horizontal
        for (int i = 0; i < SIZE; i++) {
            if (isCheckWin(symbol, i, 0, 0, 0, 1, 0, SIZE)) {
                return true;
            }
        }
        //Vertical
        for (int i = 0; i < SIZE; i++) {
            if (isCheckWin(symbol, 0, 1, 0, i, 0, 0, SIZE)) {
                return true;
            }
        }
        //Diagonal
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            if (isCheckWin(symbol, 0, 1, 0, i, 1, 0, SIZE - i)) {
                return true;
            }
            if (isCheckWin(symbol, i, 1, 0, 0, 1, 0, SIZE - i)) {
                return true;
            }
            if (isCheckWin(symbol, 0, 1, 0, -i, -1, SIZE - 1, SIZE - i)) {
                return true;
            }
            if (isCheckWin(symbol, i, 1, 0, 0, -1, SIZE - 1, SIZE - i)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isCheckWin(char symbol, int x, int mx, int px, int y, int my, int py, int len) {
        int isWin = 0;
        for (int i = 0; i < len; i++) {
            if (map[x + i * mx + px][y + i * my + py] == symbol) {
                isWin += 1;
                if (isWin == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                isWin = 0;
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void aiTurn() {
        int x;
        int y;
        if (!isBlock()) {
            do {
                x = random.nextInt(0, SIZE);
                y = random.nextInt(0, SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
    }

    public static boolean isBlock() {
        //Horizontal
        for (int i = 0; i < SIZE; i++) {
            if (isCheckBlock(i, 0, 0, 0, 1, 0, SIZE)) {
                return true;
            }
        }
        //Vertical
        for (int i = 0; i < SIZE; i++) {
            if (isCheckBlock(0, 1, 0, i, 0, 0, SIZE)) {
                return true;
            }
        }
        //Diagonal
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            if (isCheckBlock(0, 1, 0, i, 1, 0, SIZE - i)) {
                return true;
            }
            if (isCheckBlock(i, 1, 0, 0, 1, 0, SIZE - i)) {
                return true;
            }
            if (isCheckBlock(0, 1, 0, -i, -1, SIZE - 1, SIZE - i)) {
                return true;
            }
            if (isCheckBlock(i, 1, 0, 0, -1, SIZE - 1, SIZE - i)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isCheckBlock(int x, int mx, int px, int y, int my, int py, int len) {
        int isBlock = 0;
        int cntDotEmpty = 0;
        int aix = -1;
        int aiy = -1;
        for (int i = 0; i < len; i++) {
            if (map[x + i * mx + px][y + i * my + py] == DOT_X) {
                isBlock += 1;
                if (isBlock == DOTS_TO_WIN) {
                    System.out.println("Компьютер походил в точку" + (aiy + 1) + " " + (aix + 1));
                    map[aix][aiy] = DOT_O;
                    return true;
                }
            } else {
                if (map[x + i * mx + px][y + i * my + py] == DOT_EMPTY) {
                    if (cntDotEmpty == 0) {
                        cntDotEmpty = 1;
                        isBlock += 1;
                        aix = x + i * mx + px;
                        aiy = y + i * my + py;
                        if (isBlock == DOTS_TO_WIN) {
                            System.out.println("Компьютер походил в точку" + (aiy + 1) + " " + (aix + 1));
                            map[aix][aiy] = DOT_O;
                            return true;
                        }
                    } else {
                        if (mx == 0) {
                            isBlock = Math.abs(y + i * my + py - aiy);
                        } else {
                            isBlock = Math.abs(x + i * mx + px - aix);
                        }
                        aix = x + i * mx + px;
                        aiy = y + i * my + py;
                    }
                } else {
                    isBlock = 0;
                    cntDotEmpty = 0;
                }
            }
        }
        return false;
    }

    public static void humanTurn() {
        int x = -1;
        int y = -1;
        do {
            try {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("Введите числа");
                sc = new Scanner(System.in);
            }
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static void isSizeMoreThanTwo() {
        if (SIZE < 3) {
            System.out.println("Минимальный размер поля 3х3");
            System.exit(1);
        }
    }
}