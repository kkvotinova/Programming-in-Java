/*
 * Copyright (c) 2021 Ksuvot
 */

package project.brain;

public class Passenger {
    private final int currentFloor;
    private final int nextFloor;

    public Passenger(int currentFloor, int nextFloor) {
        this.currentFloor = currentFloor;
        this.nextFloor = nextFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNextFloor() {
        return nextFloor;
    }
}
