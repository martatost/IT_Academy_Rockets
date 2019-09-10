package com.martaTostSoft;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserInputInformation userInput = new UserInputInformation();
        int numberOfRockets = userInput.askForNumberOfRockets();
        List<Rocket> rockets = new ArrayList<>();

        for (int i = 0; i < numberOfRockets; i++) {
            rockets.add(userInput.askForNewRocket());
        }

        printRockets(rockets);
        printSpeed(rockets);
        accelerate3Times(rockets);
        printSpeed(rockets);

        //printCurrentSpeed();


    }

    private static void printSpeed(List<Rocket> rockets) {
        for (Rocket rocket : rockets) {
            System.out.println(rocket.getId() + ". Current speed: " + rocket.currentSpeed());
        }
    }

    private static void accelerate3Times(List<Rocket> rockets) {
        Propellant[] propellants = null;
        for (Rocket rocket : rockets) {
            propellants = rocket.getPropellants();
            for (int i = 0; i < propellants.length; i++) {
                rocket.accelerate(propellants[i]);
                rocket.accelerate(propellants[i]);
                rocket.accelerate(propellants[i]);
            }
        }
    }


    private static void printRockets(List<Rocket> rockets) {

        Propellant[] propellants = null;
        for (Rocket rocket : rockets) {
            System.out.print(rocket.getId() + ": " + rocket.getPropellants().length + " propellants");
            propellants = rocket.getPropellants();
            for (int i = 0; i < rocket.getPropellants().length; i++) {
                System.out.print(", " + propellants[i].getMaximumPower());
            }
            System.out.print("\n");
        }
    }
}
