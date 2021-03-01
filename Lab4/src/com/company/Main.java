package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Human person = new Human();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n \t \t \t \t [ Enter your last name, first name, patronymic ]");
        System.out.println("\n \t \t \t \t  [ and date of birth in the format DD.MM.YYYY ]");
        String word = scanner.nextLine();
        scanner.close();

        person.split(word, " ");
        person.split(person.getData(), "\\.");

        if (!person.checkDate()) {
            throw new IllegalArgumentException("Invalid date!");
        }

        person.answer();
    }
}
