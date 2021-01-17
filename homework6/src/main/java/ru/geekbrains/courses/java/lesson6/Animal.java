package ru.geekbrains.courses.java.lesson6;

public class Animal {
    private String name;
    private int runLimit;
    private int swimLimit;
    private static int countAnimal;

    public Animal(String name){
       this.name = name;
       countAnimal++;
    }

    public void run(int distance){
        if (runLimit == 0) {
            System.out.println(name + " не умеет бегать");
        } else {
            if (distance <= runLimit) {
                System.out.println(name + " пробежал(а) " + distance + " м.");
            } else {
                System.out.println(name + " смог/смогла пробежать только " + runLimit + " м.");
            }
        }
    }


    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать");
        } else {
            if (distance <= swimLimit) {
                System.out.println(name + " проплыл(а) " + distance + " м.");
            } else {
                System.out.println(name + " смог/смогла проплыль только " + swimLimit + " м.");
            }
        }
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public void setSwimLimit(int swimLimit) {
        this.swimLimit = swimLimit;
    }

    public static int getCountAnimal() {
        return countAnimal;
    }

}
