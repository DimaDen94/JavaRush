package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        while (level>60)
        {
            level = level-60;
        }

        Set<Wall> walls = new HashSet<>();
        Wall wall;

        Set<Box> boxes = new HashSet<>();
        Box box;

        Set<Home> homes = new HashSet<>();
        Home home;

        Player player = null;

        int y;

        int x0;
        int y0;

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile())))
        {
            String line;
            while (true)
            {
                line = reader.readLine();
                if (line.equals("Maze: " + level))
                {
                    //File offset: 148C, DS:00FC, table offset: 0000
                    reader.readLine();

                    //Size X: 22
                    String forX = reader.readLine();


                    //Size Y: 11
                    String forY = reader.readLine();
                    y = Integer.parseInt(forY.replaceAll("Size Y: ", ""));

                    //End: 14BD
                    reader.readLine();

                    //Length: 50
                    reader.readLine();

                    //
                    reader.readLine();
                    y0 = Model.FIELD_SELL_SIZE / 2;
                    for (int ver = 0; ver < y; ver++)
                    {
                        line = reader.readLine();

                        char[] chars = line.toCharArray();


                        x0 = Model.FIELD_SELL_SIZE / 2;
                        for (char c : chars)
                        {
                            switch (c)
                            {
                                case 'X':
                                    wall = new Wall(x0, y0);
                                    walls.add(wall);
                                    break;
                                case '*':
                                    box = new Box(x0, y0);
                                    boxes.add(box);
                                    break;
                                case '.':
                                    home = new Home(x0, y0);
                                    homes.add(home);
                                    break;
                                case '@':
                                    player = new Player(x0, y0);
                                    break;
                                case '&':
                                    box = new Box(x0, y0);
                                    home = new Home(x0, y0);
                                    boxes.add(box);
                                    homes.add(home);
                                    break;
                            }
                            x0 = x0 + Model.FIELD_SELL_SIZE;
                        }
                        y0 = y0 + Model.FIELD_SELL_SIZE;
                    }
                    break;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        return new GameObjects(walls, boxes, homes, player);
    }
}
