package com.martaTostSoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputOutputInformation {
    private Scanner input = new Scanner(System.in);

    public Rocket askForNewRocket() {
        Rocket newRocket = new Rocket();

        newRocket.setId(askForId());
        newRocket.setPropellants(askForRocketPropellants());
        return newRocket;
    }


    private String askForId() {

        System.out.println("Which is the rocket id code?");
        String code = input.next();
        while (code.length() != 8) {
            code = askAgainTheCode();
        }
        return code;
    }

    private String askAgainTheCode() {
        System.out.println("The Rocket id code has to have 8 characters, please, enter again");
        return input.next();
    }

    private Propellant[] askForRocketPropellants() {
        System.out.println("How many propellants have this rocket? Please enter the number");
        int numberPropellants = input.nextInt();

        Propellant[] propellants = new Propellant[numberPropellants];

        for (int i = 0; i < numberPropellants; i++) {
            propellants[i] = AskForNewPropellant(i + 1);
        }
        return propellants;
    }

    private Propellant AskForNewPropellant(int propellantId) {
        Propellant newPropellant = new Propellant();

        newPropellant.setMaximumPower(askMaximumPower(propellantId));
        newPropellant.setCurrentPower(0);
        return newPropellant;
    }

    private int askMaximumPower(int propellantId) {
        int answer = 0;
        do {
            System.out.println("Which is the maximum power for the propellant number " + propellantId + "?");
            answer = input.nextInt();
        }while (answer % 10!=0);
        return answer;
    }

    public int askForNumberOfRockets() {

        System.out.println("How many rockets do you want to enter in the system? If you answer 0 we consider that you want to work with the 2 rockets by default");
        int answer = input.nextInt();
        return answer;
    }

    public void printRockets(List<Rocket> rockets) {

        List<Rocket> printRockets = new ArrayList<>();
        printRockets = rockets;
        Propellant[] propellants = null;
        for (Rocket rocket : printRockets) {
            System.out.print(rocket.getId() + ": " + rocket.getPropellants().length + " propellants");
            propellants = rocket.getPropellants();
            for (int i = 0; i < rocket.getPropellants().length; i++) {
                System.out.print(", " + propellants[i].getMaximumPower());
            }
            System.out.print("\n");
        }
    }

    public void printCurrentSpeed(List<Rocket> rockets) {
        for (Rocket rocket : rockets) {
            System.out.println(rocket.getId() + ". Current speed: " + rocket.getSpeed());
        }
    }

    public void printRocketChangedAttibutes(Rocket rocket, String action, int actionNumber) {
        System.out.print("Rocket " + rocket.getId());
        System.out.print(". New rocket power (sum of all propellants): "+rocket.sumOfPropellants());
        System.out.print(". Current speed after " + action +" "+ actionNumber+" times: "+ rocket.getSpeed());
        System.out.print("\n");
    }
}
