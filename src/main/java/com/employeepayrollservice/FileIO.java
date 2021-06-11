package com.employeepayrollservice;

import java.io.File;

public class FileIO {
    public static boolean deleteFiles(File contentToDelete){
        File[] allContent = contentToDelete.listFiles();
        if (allContent != null){
            for (File file : allContent)
                deleteFiles(file);
        }
        return contentToDelete.delete();
    }
}
