package com.martaTostSoft;

import java.util.concurrent.*;

public class Rocket {
    private String id;
    private volatile double speed = 0.0;
    private Propellant[] propellants;
    private static final String ACCELERATE = "accelerate";
    private static final String SLOW_DOWN = "slowDown";


    public Rocket() {
    }

    public Rocket(String id, double speed, Propellant[] propellants) {
        this.id = id;
        this.speed = speed;
        this.propellants = propellants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Propellant[] getPropellants() {
        return propellants;
    }

    public void setPropellants(Propellant[] propellants) {
        this.propellants = propellants;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public void accelerate() {
        Propellant[] propellants = this.getPropellants();
        ExecutorService executor = Executors.newFixedThreadPool(propellants.length);

        for (Propellant propellant : propellants) {
            propellant.setAction(ACCELERATE);
            executor.execute(propellant);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        this.ChangeAcceleratingCurrentSpeed();
    }

    public void brake() {
        Propellant[] propellants = this.getPropellants();
        ExecutorService executor = Executors.newFixedThreadPool(propellants.length);

        for (Propellant propellant : propellants) {
            propellant.setAction(SLOW_DOWN);
            executor.execute(propellant);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        this.changeBrakingCurrentSpeed();
    }

    private void changeBrakingCurrentSpeed() {
        this.setSpeed(this.getSpeed() - (100 * Math.sqrt(Math.abs(sumOfPropellants()))));
        if (speed <= 0.0)
            this.setSpeed(0);
    }

    public void ChangeAcceleratingCurrentSpeed() {
        speed = this.getSpeed() + (100 * Math.sqrt(Math.abs(sumOfPropellants())));
    }

    public double sumOfPropellants() {
        double totalPower = 0.0;
        Propellant[] propellants = this.getPropellants();

        for (Propellant propellant : propellants)
            totalPower = totalPower + propellant.getCurrentPower();
        return totalPower;
    }
}