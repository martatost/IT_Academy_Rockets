package com.martaTostSoft;

import java.util.List;

public class Rocket {
    private String id;
    private double speed = 0.0;
    private Propellant[] propellants;

    public Rocket() {
    }

    public Rocket(String id, double speed, List<Propellant> propellants) {
        this.id = id;
        this.speed = speed;
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

    public void accelerate(Propellant propellant) {
        if (propellant.getCurrentPower() < propellant.getMaximumPower()) {
            propellant.setCurrentPower(propellant.getCurrentPower() + 10);
        } else
            propellant.setCurrentPower(propellant.getMaximumPower());
    }


    public void brake(Propellant propellant) {
        if (propellant.getCurrentPower() > 0) {
            propellant.setCurrentPower(propellant.getCurrentPower() - 10);
        } else
            propellant.setCurrentPower(0);
    }

    public double currentSpeed() {
        double currentSpeed = 0.0;
        currentSpeed = getSpeed() + Math.sqrt(sumOfPropellants());
        setSpeed(currentSpeed);
        return currentSpeed;
    }

    private double sumOfPropellants() {
        double totalPower = 0.0;

        for (Propellant propellant : propellants)
            totalPower = totalPower + propellant.getCurrentPower();
        return totalPower;
    }
}