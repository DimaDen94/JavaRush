package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Dmitry on 14.03.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        if (f.isDirectory())
            return true;
        String fileName = f.getName().toLowerCase();
        return fileName.endsWith(".html") || fileName.endsWith(".htm");
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
