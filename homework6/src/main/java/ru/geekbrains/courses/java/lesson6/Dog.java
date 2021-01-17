package ru.geekbrains.courses.java.lesson6;

public class Dog extends Animal {
    private static int countDog;

    public Dog(String name) {
        super(name);
        super.setRunLimit(500);
        super.setSwimLimit(10);
        countDog++;
    }

    public int getCountDog() {
        return countDog;
    }
}
