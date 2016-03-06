package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class Archiver
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Enter the path to the archive");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ZipFileManager manager = new ZipFileManager(Paths.get(reader.readLine()));
        System.out.println("Enter the path to the file");
        manager.createZip(Paths.get(reader.readLine()));
    }
}
