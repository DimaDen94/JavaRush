package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class ZipCreateCommand extends ZipCommand
{
    @Override
    public void execute() throws Exception
    {
        try
        {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager manager = getZipFileManager();
            ConsoleHelper.writeMessage("Полное имя файла или директории для архивации");
            Path pathToArchive = Paths.get(ConsoleHelper.readString());
            manager.createZip(pathToArchive);
            ConsoleHelper.writeMessage("Архив создан.");
        }catch (PathIsNotFoundException e){
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }

    }
}
