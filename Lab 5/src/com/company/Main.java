/*
 * Copyright (c) 2021 Ksuvot
 */

package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("{ Enter the following information }");

        System.out.print("[ number of elevators ] ");
        int numberOfElevators = Integer.parseInt(scanner.nextLine());
        System.out.print("[ elevator capacity ] ");
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());
        System.out.print("[ number of floors ] ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        System.out.print("[ maximum number of people per floor ] ");
        int maxNumberOfPeoplePerFloor = Integer.parseInt(scanner.nextLine());

        if (numberOfFloors * elevatorCapacity * numberOfElevators * maxNumberOfPeoplePerFloor > 0) {
            ElevatorControl elevatorControl = new ElevatorControl(elevatorCapacity, numberOfFloors, numberOfElevators);
            Request request = new Request(numberOfFloors, maxNumberOfPeoplePerFloor, elevatorControl);
            Thread requestsThread = new Thread(request);
            Thread elevatorsThread = new Thread(elevatorControl);
            requestsThread.start();
            elevatorsThread.start();
        }
        else {
            System.out.print("❌ WRONG ❌");
        }
    }
}
