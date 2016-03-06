package com.javarush.test.level31.lesson15.big01;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
        try (
                ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
                InputStream inputStream = Files.newInputStream(source)
        )
        {
            ZipEntry entry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(entry);
            byte[] buf = new byte[1024];
            while (inputStream.available() > 0)
            {
                int size = inputStream.read(buf);
                zipOutputStream.write(buf, 0, size);
            }
            zipOutputStream.closeEntry();
        }

    }

}
