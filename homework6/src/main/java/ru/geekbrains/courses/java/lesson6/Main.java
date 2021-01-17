package ru.geekbrains.courses.java.lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Лапка");
        Cat cat2 = new Cat("Клякса");
        Cat cat3 = new Cat("Моська");
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Собака");
        cat1.run(300);
        cat1.swim(30);
        cat2.run(20);
        cat3.run(0);
        dog1.run(3000);
        dog1.swim(3);
        dog2.run(350);
        dog2.swim(7);
        System.out.printf("Всего создано %d животных(oe): %d кошек(и) и %d собак(и) ",cat2.getCountAnimal(),dog1.getCountDog(),cat3.getCountCat());
    }
}
