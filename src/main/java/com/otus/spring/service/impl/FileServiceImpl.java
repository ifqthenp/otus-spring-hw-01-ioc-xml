package com.otus.spring.service.impl;

import com.otus.spring.service.FileService;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class FileServiceImpl implements FileService
{
    private static final String CSV_FILE = "quiz.csv";

    @Override
    public File getCsvFile()
    {
        File csvFile = null;
        try {
            csvFile = ResourceUtils.getFile("classpath:" + CSV_FILE);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return csvFile;
    }
}
