package ru.geekbrains.courses.java.lesson2;

import java.util.Arrays;

public class MainAppLesson2 {
    public static void main(String[] args) {
        //1
        invertArray(new int[]{0, 0, 1, 1, 0, 1});
        //2
        fillArray(new int[8]);
        //3
        changeArray(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        //4
        fillDiagonal();
        //5
        minMaxArray(new int[]{100, 5, 3, 2, -11, 4, 5, 2, 4, 895, -9, 1});


    }

    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillDiagonal(){
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++){
            arr[i][i] = 1;
            arr[i][arr.length-1-i] = 1;
        }
        System.out.println(Arrays.deepToString(arr));

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void minMaxArray(int[] arr) {
        int minValue = arr[0] ;
        int maxValue = arr[0];
        for (int value: arr) {
            if (value< minValue) {
                minValue = value;
            }
            if (value > maxValue){
                maxValue = value;
            }
            System.out.println("В массиве "+ Arrays.toString(arr));
            System.out.println("Минимальное значение = "+ minValue);
            System.out.println("Максимальное значение = "+ maxValue);

        }

    }
}
