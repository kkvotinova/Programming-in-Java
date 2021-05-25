/*
 * Copyright (c) 2021 Ksuvot
 */

package project.brain;

import java.util.ArrayList;

public class ElevatorControl implements Runnable {
    private int numberAvailableSeatsInElevator;
    private int numberFloorsInBuilding;
    private final ArrayList<Elevator> listOfElevators = new ArrayList<>();
    private final ArrayList<Passenger> listOfPassengers = new ArrayList<>();

    public ElevatorControl(int numberAvailableSeatsInElevator, int numberFloorsInBuilding, int numberElevatorsInBuilding) {
        setNumberAvailableSeatsInElevator(numberAvailableSeatsInElevator);
        setNumberFloorsInBuilding(numberFloorsInBuilding);
        for (int i = 0; i < numberElevatorsInBuilding; i++) {
            setListOfElevators(new Elevator(i, 0));
        }
    }

    @Override
    public void run() {
        int programIteration = 0;
        System.out.println("- * - * - * - * - * - * - [ START PROGRAM ] - * - * - * - * - * - *");
        while (true) {
            programIteration++;
            int numberOfElevatorsInvolved = 0;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> ITERATION #"+programIteration+" <<<<<<<<<<<<<<<<<<<<<<<<<<");
            for (Elevator elevator: getListOfElevators()) {
                elevator.changingTheFloor();
                int currentFloor = elevator.getCurrentFloor();
                if (getNumberAvailableSeatsInElevator() - elevator.getListOfPassengers().size() > 0) {
                    ArrayList<Passenger> upstairsCurrent = new ArrayList<>();
                    ArrayList<Passenger> downstairsCurrent = new ArrayList<>();
                    ArrayList<Passenger> upstairsNext = new ArrayList<>();
                    ArrayList<Passenger> downstairsNext = new ArrayList<>();
                    for (Passenger passenger : getListOfPassengers()) {
                        int passengerCurrentFloor = passenger.getCurrentFloor();
                        int passengerNextFloor = passengerCurrentFloor - passenger.getNextFloor();
                        if (passengerCurrentFloor > currentFloor)
                            upstairsCurrent.add(passenger);
                        else if (passengerCurrentFloor < currentFloor)
                            downstairsCurrent.add(passenger);
                        if (passengerCurrentFloor == elevator.getCurrentFloor() && passengerNextFloor < 0) {
                            upstairsNext.add(passenger);
                        }
                        else if (passengerCurrentFloor == elevator.getCurrentFloor() && passengerNextFloor > 0) {
                            downstairsNext.add(passenger);
                        }
                    }
                    if (elevator.getListOfPassengers().size() == 0 || currentFloor == getNumberFloorsInBuilding() - 1) {
                        if (elevator.getDirectionOfTravel() == 1 && (upstairsCurrent.size() <
                                numberOfElevatorsInvolved * getNumberAvailableSeatsInElevator()
                                || downstairsCurrent.size() < numberOfElevatorsInvolved * getNumberAvailableSeatsInElevator())) {
                            elevator.setDirectionOfTravel(0);
                        }
                        else if (downstairsCurrent.size() > numberOfElevatorsInvolved * getNumberAvailableSeatsInElevator()
                                || currentFloor == getNumberFloorsInBuilding() - 1) {
                            elevator.setDirectionOfTravel(-1);
                        }
                    }
                    else if (currentFloor == 0) {
                        if (upstairsCurrent.size() > numberOfElevatorsInvolved * getNumberAvailableSeatsInElevator()) {
                            elevator.setDirectionOfTravel(1);
                        }
                        else {
                            elevator.setDirectionOfTravel(0);
                        }
                    }
                    else {
                        elevator.setDirectionOfTravel(1);
                    }
                    if (elevator.getDirectionOfTravel() == 0) {
                        if (upstairsNext.size() > downstairsNext.size() && upstairsCurrent.size()
                                > numberOfElevatorsInvolved * getNumberAvailableSeatsInElevator()) {
                            elevator.setDirectionOfTravel(1);
                        }
                        else if (upstairsNext.size() <= downstairsNext.size()
                                && downstairsCurrent.size() > numberOfElevatorsInvolved * getNumberAvailableSeatsInElevator()) {
                            elevator.setDirectionOfTravel(-1);
                        }
                    }
                    if (currentFloor == getNumberFloorsInBuilding() - 1) {
                        elevator.setDirectionOfTravel(-1);
                    }
                    if (currentFloor == 0) {
                        elevator.setDirectionOfTravel(1);
                    }
                    ArrayList<Passenger> priorityPassengers = new ArrayList<>();
                    if (elevator.getDirectionOfTravel() == -1) {
                        priorityPassengers = upstairsNext;
                    }
                    else if (elevator.getDirectionOfTravel() == 1) {
                        priorityPassengers = downstairsNext;
                    }
                    while (priorityPassengers.size() != 0 && elevator.getListOfPassengers().size() < getNumberAvailableSeatsInElevator()) {
                        elevator.setListOfPassengers(priorityPassengers.get(0));
                        getListOfPassengers().remove(priorityPassengers.get(0));
                        priorityPassengers.remove(0);
                    }
                }
                else {
                    if (currentFloor == getNumberFloorsInBuilding() - 1) {
                        elevator.setDirectionOfTravel(-1);
                    }
                    if (currentFloor == 0) {
                        elevator.setDirectionOfTravel(1);
                    }
                }
                numberOfElevatorsInvolved++;
                String elevatorDirection = switch (elevator.getDirectionOfTravel()) {
                    case -1 -> "↓";
                    case 1 -> "↑";
                    default -> "✘";
                };
                System.out.println("{ id } " + elevator.getId() + " { current floor } " + elevator.getCurrentFloor() +
                        " { direction } " + elevatorDirection + " { passenger number } " + elevator.getListOfPassengers().size());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public int getNumberAvailableSeatsInElevator() {
        return numberAvailableSeatsInElevator;
    }

    public void setNumberAvailableSeatsInElevator(int numberAvailableSeatsInElevator) {
        this.numberAvailableSeatsInElevator = numberAvailableSeatsInElevator;
    }

    public int getNumberFloorsInBuilding() {
        return numberFloorsInBuilding;
    }

    public void setNumberFloorsInBuilding(int numberFloorsInBuilding) {
        this.numberFloorsInBuilding = numberFloorsInBuilding;
    }

    public ArrayList<Elevator> getListOfElevators() {
        return listOfElevators;
    }

    public void setListOfElevators(Elevator listOfElevators) {
        this.listOfElevators.add(listOfElevators);
    }

    public ArrayList<Passenger> getListOfPassengers() {
        return listOfPassengers;
    }

    public void setListOfPassengers(Passenger listOfPassengers) {
        this.listOfPassengers.add(listOfPassengers);
    }
}
