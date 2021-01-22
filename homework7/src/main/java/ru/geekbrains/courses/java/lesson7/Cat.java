package ru.geekbrains.courses.java.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite && satiety == false) {
            p.decreaseFood(appetite);
            satiety = true;
        }
    }

    public void infoSatiety() {
        if (satiety) {
            System.out.println(name + " сыт");
        } else {
            System.out.println(name + " остался голодным");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }
}
