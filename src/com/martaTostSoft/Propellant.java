package com.martaTostSoft;

public class Propellant {
    private int maximumPower;
    private int currentPower;

    public Propellant() {
        this.currentPower = 0;
    }

    public int getMaximumPower() {
        return maximumPower;
    }

    public void setMaximumPower(int maximumPower) {
        this.maximumPower = maximumPower;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }
}
