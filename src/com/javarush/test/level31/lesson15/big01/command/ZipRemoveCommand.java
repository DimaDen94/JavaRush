package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class ZipRemoveCommand extends ZipCommand
{
    @Override
    public void execute() throws Exception
    {
            ConsoleHelper.writeMessage("Удаление файла");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите путь к файлу");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.removeFile(destinationPath);

            ConsoleHelper.writeMessage("Файл удален");


    }
}
