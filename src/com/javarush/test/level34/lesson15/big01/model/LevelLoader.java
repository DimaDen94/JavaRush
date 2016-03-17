package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmitry on 17.03.2016.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level)
    {
        Set<Wall> walls = new HashSet<>();
        Wall wall1 = new Wall(40,40);
        Wall wall2 = new Wall(60,40);
        Wall wall3 = new Wall(80,40);
        walls.add(wall1);
        walls.add(wall2);
        walls.add(wall3);

        Set<Box> boxes = new HashSet<>();
        Box box = new Box(80,80);
        boxes.add(box);

        Set<Home> homes = new HashSet<>();
        Home home = new Home(60,90);
        homes.add(home);

        Player player = new Player(100,100);


        return new GameObjects(walls,boxes,homes,player);
    }
}
