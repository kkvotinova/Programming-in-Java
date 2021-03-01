package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Human person = new Human();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n \t \t \t \t [ Enter your last name, first name, patronymic ]");
        System.out.println("\n \t \t \t \t  [ and date of birth in the format DD.MM.YYYY ]");
        String word = scanner.nextLine();

        person.split(word, " ");
        person.split(person.getData(), "\\.");

        if (!person.checkDate()) {
            throw new IllegalArgumentException("Invalid date!");
        }

        System.out.print(person.getLastName() + " ");
        System.out.print(person.getFirstName() + " ");
        System.out.print(person.getPatronymic() + "\n");

        System.out.print(person.getDay() + " ");
        System.out.print(person.getMonth() + " ");
        System.out.print(person.getYear() + "\n");

        person.determiningZodiacSign();
        System.out.print(person.getZodiacSign() + "\n");
    }
}
