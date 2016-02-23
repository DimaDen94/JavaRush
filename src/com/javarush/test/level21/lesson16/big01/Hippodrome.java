package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Dmitry on 12.01.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;
    public static void main(String[] ars) throws InterruptedException
    {
        game = new Hippodrome();

        game.getHorses().add(new Horse("Homer",3,0));
        game.getHorses().add(new Horse("Bart",3,0));
        game.getHorses().add(new Horse("March", 3, 0));
        game.run();

    }
    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100 ; i ++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse hor :horses ){
            hor.move();
        }

    }
    public void print(){
        for (Horse hor :horses ){
            hor.print();
        }
        System.out.println();
        System.out.println();
    }
    public Horse getWinner() {
        double max =0;
        Horse winer = null;
        for (Horse hor :horses ){
            if(hor.getDistance()>max){
                max = hor.getDistance();
                winer = hor;
            }
        }
        return winer;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");

    }
}
