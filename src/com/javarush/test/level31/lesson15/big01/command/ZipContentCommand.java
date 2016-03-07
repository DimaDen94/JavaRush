package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.FileProperties;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.util.List;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class ZipContentCommand extends ZipCommand
{
    @Override
    public void execute() throws Exception
    {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager manager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> properties = manager.getFilesList();
        for (FileProperties prop: properties){
            ConsoleHelper.writeMessage(prop.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");

    }
}
