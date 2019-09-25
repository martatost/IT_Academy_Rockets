package com.martaTostSoft;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String ROCKET1 = "32WESSDS";
    private static final int ROCKET1_PROPELLANTS = 3;
    private static final int[] ROCKET1_MAX_POWER_PROPELLANTS = {10, 30, 80};
    private static final String ROCKET2 = "LDSFJA32";
    private static final int ROCKET2_PROPELLANTS = 6;
    private static final int[] ROCKET2_MAX_POWER_PROPELLANTS = {30, 40, 50, 50, 30, 10};
    private static final String ACCELERATE = "accelerate";
    private static final String SLOW_DOWN = "slow down";


    public static void main(String[] args) throws InterruptedException {

        UserInputOutputInformation userIO = new UserInputOutputInformation();
        List<Rocket> rockets = new ArrayList<>();
        int numberOfRockets = userIO.askForNumberOfRockets();

        for (int i = 0; i < numberOfRockets; i++) {
            rockets.add(userIO.askForNewRocket());
        }

        if (numberOfRockets == 0) {
            rockets = getDefaultRockets();
        }

        userIO.printRockets(rockets);
        userIO.printCurrentSpeed(rockets);
        point4accelerate3Times(rockets);
        userIO.printCurrentSpeed(rockets);
        point6SlowDown5TimesAccelerate7Times(rockets);
        userIO.printCurrentSpeed(rockets);
        point8accelerate15Times(rockets);
        userIO.printCurrentSpeed(rockets);

    }

    private static List<Rocket> getDefaultRockets() {
        List<Rocket> rockets = new ArrayList<>();

        rockets.add(defaultRocket1());
        rockets.add(defaultRocket2());
        return rockets;
    }


    private static Rocket defaultRocket1() {
        Propellant[] propellants = new Propellant[ROCKET1_PROPELLANTS];

        for (int i = 0; i < ROCKET1_PROPELLANTS; i++) {
            Propellant propellant = new Propellant();
            propellant.setMaximumPower(ROCKET1_MAX_POWER_PROPELLANTS[i]);
            propellants[i]= propellant;
        }

        Rocket rocket = new Rocket(ROCKET1, 0.0, propellants);
        return rocket;
    }

    private static Rocket defaultRocket2() {
        Propellant[] propellants = new Propellant[ROCKET2_PROPELLANTS];

        for (int i = 0; i < ROCKET2_PROPELLANTS; i++) {
            Propellant propellant = new Propellant();
            propellant.setMaximumPower(ROCKET2_MAX_POWER_PROPELLANTS[i]);
            propellants[i]= propellant;
        }
        Rocket rocket = new Rocket(ROCKET2, 0.0, propellants);
        return rocket;
    }


    private static void point4accelerate3Times(List<Rocket> rockets) {

        UserInputOutputInformation userIO = new UserInputOutputInformation();

        System.out.println("Begins point: 4. Accelerar amb els coets tres cops");
        for (Rocket rocket : rockets) {
            for (int i = 0; i < 3; i++) {
                rocket.accelerate();
                userIO.printRocketChangedAttibutes(rocket,ACCELERATE,i+1);
            }
        }
    }

    private static void point6SlowDown5TimesAccelerate7Times(List<Rocket> rockets) {

        UserInputOutputInformation userIO = new UserInputOutputInformation();
        System.out.println("Begins point: 6. Frenar cinc cops amb el primer coet (“32WESSDS”) i accelerar set amb el segon coet.");
        for (Rocket rocket : rockets) {
            switch (rocket.getId()) {
                case ROCKET1:
                    for (int i = 0; i < 5; i++) {
                        rocket.brake();
                        userIO.printRocketChangedAttibutes(rocket,SLOW_DOWN,i+1);
                    }
                    break;
                case ROCKET2:
                    for (int j = 0; j < 7; j++) {
                        rocket.accelerate();
                        userIO.printRocketChangedAttibutes(rocket,ACCELERATE,j+1);
                    }
                    break;
            }
        }
    }

    private static void point8accelerate15Times(List<Rocket> rockets) {
        UserInputOutputInformation userIO = new UserInputOutputInformation();

        System.out.println("Begins point: 8. Accelerar 15 cops amb els dos coets.");
        for (Rocket rocket : rockets) {
            for (int i = 0; i < 15; i++) {
                rocket.accelerate();
                userIO.printRocketChangedAttibutes(rocket,ACCELERATE,i+1);
            }
        }
    }
}