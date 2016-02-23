package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Dmitry on 12.01.2016.
 */
public class Horse
{
    String name;
    double speed;
    double distance;
    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
    public void move(){
        int random = (int) Math.random();

        distance += speed * random;
    }
    public void print(){
        StringBuilder dots = new StringBuilder();

        for (int i =0; i < (int)distance; i++){
            dots.append(".");
        }
        dots.append(name);
        System.out.println(dots.toString());
    }

}
