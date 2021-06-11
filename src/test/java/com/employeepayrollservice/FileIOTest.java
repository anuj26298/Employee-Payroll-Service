package com.employeepayrollservice;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class FileIOTest {
    Path path = Paths.get("C:\\Users\\ANUJ\\IdeaProjects\\PayrollFolder");

    @Test
    public void givenFilePath_WhenExist_ReturnTrue() {
        Assert.assertTrue(Files.exists(path));
    }

    @Test
    public void givenFilePath_CheckandDelete_ReturnTrueIfDeleted() {
        if (Files.exists(path))
            FileIO.deleteFiles(path.toFile());
        Assert.assertTrue(Files.notExists(path));
    }

    @Test
    public void givenFilePath_WhenCreateDirectory_ReturnTrue() throws IOException {
        Files.createDirectory(path);
        Assert.assertTrue(Files.exists(path));
    }

    @Test
    public void givenPath_CreateFiles_ReturnTrue() {
        IntStream.range(1,5).forEach(counter -> {
            Path pathFiles = Paths.get(path + "\\path" + counter);
            Assert.assertTrue(Files.notExists(pathFiles));
            try {
                Files.createFile(pathFiles);
            }catch (IOException e){
                e.printStackTrace();
            }
            Assert.assertTrue(Files.exists(pathFiles));
        });
    }

    @Test
    public void givenPath_ListAllFiles() throws IOException {
        Files.list(path)
                .filter(Files :: isRegularFile)
                .forEach(System.out :: println);
    }
}
