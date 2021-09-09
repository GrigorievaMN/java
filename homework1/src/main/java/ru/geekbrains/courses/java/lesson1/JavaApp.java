package ru.geekbrains.courses.java.lesson1;

public class JavaApp {
    // 1
    public static void main (String[] args) {
        // 2
        byte val_byte = -101;
        short val_short = 32666;
        int val_int = 100000;
        long val_long = 111111L;
        float val_float = 15.156f;
        double val_double = 15.156;
        char val_char = '*';
        boolean val_boolean = false;
        // 3
        System.out.println(calculate (1.2f,1.9f,1.13f,5.98f));
        // 4
        System.out.println(task10and20(5,10));
        // 5
        isPositiveOrNegative(0);
        // 6
        System.out.println(isNegative(-100));
        //7
        greetings("Marina");
        //8
        if (isLeapYear(2024)) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }

    }

    public static float calculate (float a, float b, float c, float d) {

        return  a * (b + (c / d));
    }

    public static boolean task10and20 (int x1, int x2) {
         if (x1 + x2 >= 10 && x1 + x2 <= 20)
             return true;

         return false;
    }

    public static void isPositiveOrNegative(int x) {
        if (x>=0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int x){
        if (x>=0)  return false;

        return true;
    }

    public static void greetings (String name){
        System.out.println("Привет, "+ name + "!");
    }

    public static boolean isLeapYear ( int Year) {
        if (Year%400==0 || (Year%4==0 && Year%100!=0)) {
            return true;
        } else {
            return false;
        }
    }
}
