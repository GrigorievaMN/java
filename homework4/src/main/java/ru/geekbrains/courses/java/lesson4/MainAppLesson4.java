package ru.geekbrains.courses.java.lesson4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainAppLesson4 {
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
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
        if(map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol)
            return true;
        if(map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol)
            return true;
        if(map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol)
            return true;
        if(map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol)
            return true;
        if(map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol)
            return true;
        if(map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol)
            return true;
        if(map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol)
            return true;
        if(map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol)
            return true;

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
        for(int i = 1; i <= SIZE; i ++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void aiTurn() {
        int x;
        int y;
        do {
                x = random.nextInt(0, SIZE);
                y = random.nextInt(0, SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x = -1;
        int y = -1;
        do {
            try {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } catch ( InputMismatchException e) {
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
        if(SIZE < 3) {
            System.out.println("Минимальный размер поля 3х3");
            System.exit(1);
        }
    }
}

