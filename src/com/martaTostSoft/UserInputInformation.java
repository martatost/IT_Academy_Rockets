package com.martaTostSoft;

import java.util.Scanner;

public class UserInputInformation {
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
        System.out.println("Which is the maximum power for the propellant number " + propellantId + "?");
        int answer = input.nextInt();
        return answer;
    }

    public int askForNumberOfRockets() {

        System.out.println("How many rockets do you want to enter in the system?");
        int answer = input.nextInt();
        return answer;
    }

}
