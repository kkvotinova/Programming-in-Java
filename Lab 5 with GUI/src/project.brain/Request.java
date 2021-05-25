/*
 * Copyright (c) 2021 Ksuvot
 */

package project.brain;

import java.util.Random;

public class Request implements Runnable {
    private int currentFloor;
    private int maxPeopleOnFloor;
    private ElevatorControl elevatorControl;

    public Request(int currentFloor, int maxPeopleOnFloor, ElevatorControl elevatorControl) {
        setCurrentFloor(currentFloor);
        setMaxPeopleOnFloor(maxPeopleOnFloor);
        setElevatorControl(elevatorControl);
    }

    @Override
    public void run() {
        while(true) {
            Random random = new Random();
            int currentFloor = random.nextInt(this.currentFloor + 1);
            int numberOfPeople = random.nextInt(maxPeopleOnFloor + 1);
            for (int i = 0; i < numberOfPeople; i++) {
                int nextFloor = random.nextInt(this.currentFloor + 1);
                while (nextFloor == currentFloor) {
                    nextFloor = random.nextInt(this.currentFloor + 1);
                }
                getElevatorControl().setListOfPassengers(new Passenger(currentFloor, nextFloor));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setMaxPeopleOnFloor(int maxPeopleOnFloor) {
        this.maxPeopleOnFloor = maxPeopleOnFloor;
    }

    public ElevatorControl getElevatorControl() {
        return elevatorControl;
    }

    public void setElevatorControl(ElevatorControl elevatorControl) {
        this.elevatorControl = elevatorControl;
    }
}
