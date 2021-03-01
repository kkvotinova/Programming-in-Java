package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Human person = new Human();
        System.out.println("\n \t \t \t \t [ Enter your last name first name and patronymic ]");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        person.split(word, " ");

        System.out.println("\n \t \t \t [ Enter your date of birth in the format DD/MM/YYYY ]");
        word = scanner.nextLine();
        person.split(word, "/");

        System.out.print(person.getLastName() + " ");
        System.out.print(person.getFirstName() + " ");
        System.out.println(person.getPatronymic());

        System.out.print(person.getDay() + ".");
        System.out.print(person.getMonth() + ".");
        System.out.println(person.getYear());
    }
}
// TODO: знак зодиака