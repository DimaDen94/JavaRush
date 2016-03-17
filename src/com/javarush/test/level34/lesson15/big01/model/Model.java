package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by Dmitry on 17.03.2016.
 */
public class Model
{
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("D:\\HOBBY\\Java\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));

    private EventListener eventListener;
    public static int FIELD_SELL_SIZE = 20;

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }
    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }
    public void restart(){
        restartLevel(currentLevel);
    }
    public void startNextLevel(){
        currentLevel++;
        restart();
    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public void move(Direction direction)
    {

    }
}
