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

    private static boolean isWin(char symbol) {

        for (int i = 0; i < SIZE; i++) {
            int isWinHorizontal = 0;
            int isWinVertical = 0;
            for (int j = 0; j < SIZE; j++) {
                //Horizontal
                if (map[i][j] == symbol) {
                    isWinHorizontal += 1;
                    if (isWinHorizontal == DOTS_TO_WIN) return true;
                } else {
                    isWinHorizontal = 0;
                    }
                //Vertical
                if (map[j][i] == symbol) {
                    isWinVertical += 1;
                    if (isWinVertical == DOTS_TO_WIN) return true;
                } else {
                    isWinVertical = 0;
                }
            }
        }
        return checkDiagonal(symbol);
    }

    public static boolean checkDiagonal (char symbol) {
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            int isWinDiagonalOne = 0;
            int isWinDiagonalOneDown = 0;
            int isWinDiagonalTwo = 0;
            int isWinDiagonalTwoDown = 0;
            for (int j = 0; j < SIZE; j++) {
                //DiagonalOne
                if (i == 0) {
                    if (map[j][j] == symbol) {
                        isWinDiagonalOne += 1;
                        if (isWinDiagonalOne == DOTS_TO_WIN) return true;
                    } else {
                        isWinDiagonalOne = 0;
                    }
                    //DiagonalTwo
                    if (map[j][SIZE - 1 - j] == symbol) {
                        isWinDiagonalTwo += 1;
                        if (isWinDiagonalTwo == DOTS_TO_WIN) return true;
                    } else {
                        isWinDiagonalTwo = 0;
                    }
                }
                if (i > 0 && i + j < SIZE) {
                    if (map[j][j + i] == symbol) {
                        isWinDiagonalOne += 1;
                        if (isWinDiagonalOne == DOTS_TO_WIN) return true;

                    } else {
                        isWinDiagonalOne = 0;
                    }
                    if (map[j + i][j] == symbol) {
                        isWinDiagonalOneDown += 1;
                        if (isWinDiagonalOneDown == DOTS_TO_WIN) return true;

                    } else {
                        isWinDiagonalOneDown = 0;
                    }
                    if (map[j + i][SIZE - 1 - j] == symbol) {
                        isWinDiagonalTwo += 1;
                        if (isWinDiagonalTwo == DOTS_TO_WIN) return true;
                    } else {
                        isWinDiagonalTwo = 0;
                    }
                    if (map[j][SIZE - 1 - j - i] == symbol) {
                        isWinDiagonalTwoDown += 1;
                        if (isWinDiagonalTwoDown == DOTS_TO_WIN) return true;
                    } else {
                        isWinDiagonalTwoDown = 0;
                    }

                }

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
        if (!isHorizontalBlock()) {
            if (!isVerticalBlock()) {
                do {
                    x = random.nextInt(0, SIZE);
                    y = random.nextInt(0, SIZE);
                } while (!isCellValid(x, y));
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            }
        }
    }

     public static boolean isHorizontalBlock() {
        for (int i = 0; i < SIZE; i++) {
            int isHorizontalBlock = 0;
            int cntDotEmpty = 0;
            int x = -1;
            int y = -1;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    isHorizontalBlock += 1;
                    if (isHorizontalBlock == DOTS_TO_WIN) {
                        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                        map[x][y] = DOT_O;
                        return true;
                    }
                } else {
                    if (map[i][j] == DOT_EMPTY) {
                        if (cntDotEmpty == 0) {
                            cntDotEmpty = 1;
                            isHorizontalBlock += 1;
                            x = i;
                            y = j;
                            if (isHorizontalBlock == DOTS_TO_WIN) {
                                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                                map[x][y] = DOT_O;
                                return true;
                            }
                        } else {
                            isHorizontalBlock = j - y;
                            x = i;
                            y = j;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean isVerticalBlock() {
        for (int i = 0; i < SIZE; i++) {
            int isVerticalBlock = 0;
            int cntDotEmpty = 0;
            int x = -1;
            int y = -1;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == DOT_X) {
                    isVerticalBlock += 1;
                    if (isVerticalBlock == DOTS_TO_WIN) {
                        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                        map[x][y] = DOT_O;
                        return true;
                    }
                } else {
                    if (map[j][i] == DOT_EMPTY) {
                        if (cntDotEmpty == 0) {
                            cntDotEmpty = 1;
                            isVerticalBlock += 1;
                            x = j;
                            y = i;
                            if (isVerticalBlock == DOTS_TO_WIN) {
                                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                                map[x][y] = DOT_O;
                                return true;
                            }
                        } else {
                            isVerticalBlock = j - x;
                            x = j;
                            y = i;
                        }
                    }
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

    private static void isSizeMoreThanTwo() {
        if (SIZE < 3) {
            System.out.println("Минимальный размер поля 3х3");
            System.exit(1);
        }
    }
}

