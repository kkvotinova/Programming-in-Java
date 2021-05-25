/*
 * Copyright (c) 2021 Ksuvot
 */

package project.brain;

import java.util.ArrayList;

public class Elevator {
    private final int id;
    private int currentFloor;
    private int directionOfTravel;
    private final ArrayList<Passenger> listOfPassengers = new ArrayList<>();

    public Elevator(int id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
    }

    public void changingTheFloor() {
        this.currentFloor += this.directionOfTravel;
        getListOfPassengers().removeIf(listOfPassengers -> (listOfPassengers.getNextFloor() == getCurrentFloor()));
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getDirectionOfTravel() {
        return directionOfTravel;
    }

    public void setDirectionOfTravel(int directionOfTravel) {
        this.directionOfTravel = directionOfTravel;
    }

    public ArrayList<Passenger> getListOfPassengers() {
        return listOfPassengers;
    }

    public void setListOfPassengers(Passenger listOfPassengers) {
        this.listOfPassengers.add(listOfPassengers);
    }
}
