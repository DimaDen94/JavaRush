package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitry on 06.03.2016.
 */
public abstract class ZipCommand implements Command
{
    public ZipFileManager getZipFileManager() throws Exception
    {
        ConsoleHelper.writeMessage("Полный путь файла архива.");
        Path path = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(path);
    }
}
