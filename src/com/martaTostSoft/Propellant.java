package com.martaTostSoft;

public class Propellant implements Runnable {
    private String name;
    private int maximumPower;
    private int currentPower;
    private String Action;

    private static final String ACCELERATE = "accelerate";
    private static final String SLOW_DOWN = "slowDown";


    public Propellant() {
        this.currentPower = 0;
    }

    public Propellant(String name) {
        this.name = name;
        this.currentPower = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
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


    @Override
    public void run() {
        switch (getAction()) {
            case ACCELERATE:
                this.Accelerate();
                break;
            case SLOW_DOWN:
                this.SlowDown();
                break;
        }
    }


    private void Accelerate() {
        if (!propellantIsAtMaximumPower()) {
            setCurrentPower(getCurrentPower() + 10);
        }
    }

    private boolean propellantIsAtMaximumPower() {
        return getCurrentPower() >= getMaximumPower();
    }

    private void SlowDown() {

        if (!propellantIsAtMinimumPower())
            setCurrentPower(getCurrentPower() - 10);
    }

    private boolean propellantIsAtMinimumPower() {
        if (getCurrentPower() == (-(getMaximumPower()))){
            return true;
        }else
            return false;
    }
}
