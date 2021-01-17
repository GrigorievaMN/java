package ru.geekbrains.courses.java.lesson6;

public class Cat extends Animal {
    private static int countCat;

    public Cat (String name) {
        super(name);
        super.setRunLimit(200);
        super.setSwimLimit(0);
        countCat++;
        }

    public int getCountCat() {
        return countCat;
    }
}
