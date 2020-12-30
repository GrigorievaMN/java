package ru.geekbrains.courses.java.lesson3;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainAppLesson3 {
    private static final int CNT_TRY = 3;
    private static final int MAX_LIMIT = 9;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        gameSelection();
    }

    private static void gameSelection() {
        System.out.println("Выбор игры:\n 0 - Выход\n 1 – Угадай число\n 2 – Угадай слово");
        int game = sc.nextInt();
        switch (game) {
            case 1:
                guessNumberGame(MAX_LIMIT);
            break;
        }
    }

    private static void guessNumberGame(int max) {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, max + 1);
        System.out.printf("Я загадал число от 0 до %d\nПопробуй его угадать) Количество попыток = %d\n", max, CNT_TRY);
        int myNumber;

        for (int i = 0; i < CNT_TRY; i++) {
            myNumber = sc.nextInt();
            //System.out.println(randomNumber);
            if (myNumber == randomNumber) {
                System.out.printf("Вы победили! Это действительно %d\n\n", randomNumber);
                break;
            }
            if (randomNumber > myNumber) {
                System.out.println("Вы назвали слишком маленькое число");
            } else {
                System.out.println("Вы назвали слишком большое число");
            }
            if (i == CNT_TRY - 1) {
                System.out.printf("Вы проиграли( Я загадал %d\n\n", randomNumber);
            }
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int repeatGame = sc.nextInt();
        switch (repeatGame) {
            case 0:
                gameSelection();
                break;
            case 1:
                guessNumberGame(MAX_LIMIT);
                break;
        }
    }
}
