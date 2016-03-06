package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class FileManager
{
    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException
    {
        this.rootPath = rootPath;
        fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    private void collectFileList(Path path) throws IOException
    {
        if (Files.isRegularFile(path))
            fileList.add(rootPath.relativize(path));
        else if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path)) {
                for (Path subPath : dirStream) {
                    collectFileList(subPath);
                }
            }
        }
    }

    public List<Path> getFileList()
    {
        return fileList;
    }
}
