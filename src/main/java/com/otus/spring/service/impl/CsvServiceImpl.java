package com.otus.spring.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.otus.spring.domain.Quiz;
import com.otus.spring.service.CsvService;
import com.otus.spring.service.FileService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvServiceImpl implements CsvService
{
    private FileService fileService;

    public CsvServiceImpl(final FileService fileService)
    {
        this.fileService = fileService;
    }

    @Override
    public CSVReader getCsvReader()
    {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(fileService.getCsvFile()));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return csvReader;
    }

    @Override
    public List<Quiz> getQuizList()
    {
        List<Quiz> beans = null;
        try {
            beans = new CsvToBeanBuilder<Quiz>(new FileReader(fileService.getCsvFile()))
                    .withType(Quiz.class).build().parse();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return beans;
    }
}
