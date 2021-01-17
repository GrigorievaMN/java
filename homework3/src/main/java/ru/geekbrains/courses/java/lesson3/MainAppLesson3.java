package ru.geekbrains.courses.java.lesson3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainAppLesson3 {
    private static final int CNT_TRY = 3;
    private static final int MAX_LIMIT = 9;
    private static final String[] LIST_WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
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
            case 2:
                guessWordGame(LIST_WORDS);
                break;
        }
    }

    private static void guessWordGame(String[] listWords) {
        String word = listWords[ThreadLocalRandom.current().nextInt(0, listWords.length)];
        String userPrintWord = "###############";
        System.out.printf("Я загадал слово.Попробуй его угадать)\n%s\n",userPrintWord);
        String userWord = sc.next();
        if (isWinWord(word, userWord)) {
            System.out.printf("Вы победили! Это действительно %s\n\n", word);
        } else {
            while (true) {
                for (int i = 0; i < word.length() && i < userWord.length(); i++) {
                    if (word.charAt(i) == userWord.charAt(i)) {
                        char[] arrPrintWord = userPrintWord.toCharArray();
                        arrPrintWord[i] = userWord.charAt(i);
                        userPrintWord = String.valueOf(arrPrintWord);
                    }
                }
                if (isWinWord(word, userPrintWord)) {
                    System.out.printf("Вы победили! Это действительно %s\n\n", word);
                    break;
                }
                System.out.printf("Я загадал другое слово (Для выхода введите 'exit'). Попробуйте еще раз\n %s\n", userPrintWord);
                userWord = sc.next();
                if (isWinWord("exit", userWord)){
                    System.out.println();
                    break;
                }
            }
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int repeatGame = sc.nextInt();
        switch (repeatGame) {
            case 0:
                gameSelection();
                break;
            case 1:
                guessWordGame(LIST_WORDS);
                break;
        }
    }

    public static boolean isWinWord(String aiWord, String humanWord) {
        if (aiWord.length() > humanWord.length()) {
            return false;
        }
        for (int i = 0; i < aiWord.length(); i++) {
            if (aiWord.charAt(i) != humanWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    private static void guessNumberGame(int max) {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, max + 1);
        System.out.printf("Я загадал число от 0 до %d\nПопробуй его угадать) Количество попыток = %d\n", max, CNT_TRY);
        int userNumber;

        for (int i = 0; i < CNT_TRY; i++) {
            userNumber = sc.nextInt();
            if (userNumber == randomNumber) {
                System.out.printf("Вы победили! Это действительно %d\n\n", randomNumber);
                break;
            }
            if (randomNumber > userNumber) {
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
