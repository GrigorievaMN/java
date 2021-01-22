package ru.geekbrains.courses.java.lesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(0);
        plate.info();
        plate.increaseFood(300);
        plate.info();
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Barsik", 100);
        cat[1] = new Cat("Tuzik", 85);
        cat[2] = new Cat("Lapka", 150);
        cat[3] = new Cat("Cat", 50);
        cat[4] = new Cat("Knopka", 85);

        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            cat[i].infoSatiety();
        }

    }
}
