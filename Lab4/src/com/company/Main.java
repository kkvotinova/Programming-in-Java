package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Human person = new Human();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n \t \t \t \t [ Enter your last name, first name and patronymic ]");
        String word = scanner.nextLine();
        person.split(word, " ");

        System.out.println("\n \t \t \t \t [ Enter your date of birth in the format DD/MM/YYYY ]");
        word = scanner.nextLine();
        person.split(word, "/");

        if (!person.checkDate()) {
            throw new IllegalArgumentException("Invalid date!");
        }
    }
}
/* TODO:
    * знак зодиака - ПРОВЕРИТЬ*/
