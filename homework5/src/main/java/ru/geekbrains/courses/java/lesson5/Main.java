package ru.geekbrains.courses.java.lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //4
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231231278", 50500, 41);
        persArray[1] = new Person("Petrov Petr", "Manager", "petpetr@mailbox.com", "89213251616", 35000, 24);
        persArray[2] = new Person("Sidorov Fedor", "Courier", "sidfedor@mailbox.com", "89205123648", 25000, 27);
        persArray[3] = new Person("Ivanova Mariya", "Accountant", "ivmariya@mailbox.com", "89271231315", 70500, 53);
        persArray[4] = new Person("Gruzkova Olga", "Secretary", "grolga@mailbox.com", "89231231299", 30500, 21);

        //5
        for (int i = 0; i < persArray.length; i++ ) {
            if (persArray[i].getAge() > 40) {
                persArray[i].printPersonInfo();
            }
        }
    }
}
