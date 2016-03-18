package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

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

    public void restartLevel(int level)
    {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart()
    {
        restartLevel(currentLevel);
    }

    public void startNextLevel()
    {
        currentLevel++;
        restart();
    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public void move(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollision(direction)){
            return;
        }



        if (direction == Direction.UP)
            {
                player.move(0, -Model.FIELD_SELL_SIZE);

            } else if (direction == Direction.DOWN)
            {
                player.move(0, Model.FIELD_SELL_SIZE);
            } else if (direction == Direction.LEFT)
            {
                player.move(-Model.FIELD_SELL_SIZE, 0);
            } else if (direction == Direction.RIGHT)
            {
                player.move(Model.FIELD_SELL_SIZE, 0);
            }
        checkCompletion();

    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
    {
        Set<Wall> walls = gameObjects.getWalls();

        for (Wall wall : walls)
        {
            if (gameObject.isCollision(wall, direction))
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {
        Player player = gameObjects.getPlayer();


        GameObject  stoped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player)&&!(gameObject instanceof Home) && player.isCollision(gameObject, direction)){
                stoped = gameObject;
            }
        }

        if ((stoped == null)){
            return false;
        }
        if (stoped instanceof Box){
            Box stopedBox = (Box)stoped;
            if (checkWallCollision(stopedBox, direction)){
                return true;
            }
            for (Box box : gameObjects.getBoxes()){
                if(stopedBox.isCollision(box, direction)){
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;
    }

    public void checkCompletion()
    {
        Set<Box> boxes = gameObjects.getBoxes();
        Set<Home> homes = gameObjects.getHomes();
        int homesCount = homes.size();
        int count = 0;
        for (Home home : homes)
        {

            for (Box box : boxes)
            {
                if (home.getX() == box.getX() && home.getY() == box.getY())
                {
                    count++;
                }
            }
        }
        if (homesCount == count)
            eventListener.levelCompleted(currentLevel);
    }
}
