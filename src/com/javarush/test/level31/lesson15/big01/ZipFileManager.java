package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class ZipFileManager
{
    private Path zipFile;
    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }
    public void createZip(Path source) throws Exception
    {
        if(!zipFile.getParent().toFile().exists()){
            Files.createDirectories(zipFile.getParent());
        }
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile)))
        {
            if(Files.isRegularFile(source)){
                addNewZipEntry(zos,source.getParent(),source.getFileName());
            }
            else if (Files.isDirectory(source)){
                FileManager fileManager = new FileManager(source);
                List<Path> fileName = fileManager.getFileList();
                for(Path path: fileName){
                    addNewZipEntry(zos,source,path);
                }
            }else  throw new PathIsNotFoundException();
            zos.closeEntry();
        }
    }
    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName)throws Exception{
        Path fullPath = filePath.resolve(fileName);
        try(InputStream inputStream =Files.newInputStream(fullPath))
        {
            ZipEntry entry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(entry);
            copyData(inputStream,zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }
    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer))> 0)
            out.write(buffer, 0, length);
    }
}