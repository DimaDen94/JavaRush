package com.javarush.test.level29.lesson15.big01.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private static int type;

    private boolean driverAvailable;
    private int numberOfPassengers;
    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }
    public static Car create(int type, int numberOfPassengers){
        switch (type) {
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case TRUCK:
                return new Truck(numberOfPassengers);
            default:
                return null;
        }
    }

    public void fill(double numberOfLiters) throws Exception
    {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }
    private boolean canPassengersBeTransferred(){
        if(isDriverAvailable()&&fuel>0)
            return true;
        return false;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        if (date.before(summerStart) || date.after(summerEnd)) {
            return false;
        }else
            return true;
    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }
    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd)
    {
        if (isSummer(date, summerStart, summerEnd))
            return getSummerConsumption(length);
        else
            return getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred())
            return numberOfPassengers;
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
        fastenDriverBelt();

    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}
