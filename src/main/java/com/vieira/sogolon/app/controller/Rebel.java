package com.vieira.sogolon.app.controller;

import com.vieira.sogolon.app.enums.Race;
import lombok.*;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rebel {
    Scanner scan;

    @Getter
    private String name;

    @Getter
    private int Age;

    @Getter
    private Race race;

    public void askData() {
        this.scan = new Scanner(System.in);

        this.name = this.askName();
        this.Age = this.askAge();
        this.race = this.askRace();
    }

    private String askName() {
        String name = "";

        System.out.println("################## What is your name? #####################");
        System.out.print("#: ");

        do {
            try {
                name = scan.next();
                if(name.isBlank()) {
                    System.out.println("#: Please, fill in the name field!");
                    System.out.print("#: ");
                    name = "";
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Write your name, please!");
                System.out.print("#: ");
            }
            scan.nextLine();
        } while (name.equals(""));

        System.out.println(" ");
        return name;
    }

    private int askAge() {
        int age = 0;

        System.out.println("################## How old are you? #####################");
        System.out.print("#: ");

        do {
            try {
                age = scan.nextInt();
                if (age < 0 || age > 150) {
                    System.out.println("#: You entered an invalid age!");
                    System.out.print("#: ");
                    age = 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Invalid age!");
            }
            scan.nextLine();
        } while(age == 0);

        System.out.println(" ");
        return age;
    }

    private Race askRace() {
        int index = -1;

        System.out.println("################## What is your rebel race? #####################");
        for (Race race : Race.values()) {
            System.out.printf("%d - %s %n", race.ordinal(), race.name());
        }
        System.out.print("#: ");

        do {
            try {
                index = scan.nextInt();
                if(index < 0 || index >= Race.values().length) {
                    System.out.println("#: You entered an invalid index! Please, correct it!");
                    System.out.print("#: ");
                    continue;
                }
                for (Race race : Race.values()) {
                    if (index == race.ordinal()) {
                        return Race.valueOf(race.name());
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Invalid index! Please, fill in this field correctly!");
                System.out.print("#: ");
            }
            scan.nextLine();
        } while (index < 0);

        System.out.println(" ");

        return null;
    }

    @Override
    public String toString() {
        return "Rebel Name: " + this.name + " - " + "Rebel Age: " + this.Age + " - " + "Rebel Race: " + this.race;
    }

}
