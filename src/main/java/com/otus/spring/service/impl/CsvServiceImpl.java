package com.otus.spring.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.otus.spring.domain.Quiz;
import com.otus.spring.service.CsvService;
import com.otus.spring.service.ResourceService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CsvServiceImpl implements CsvService
{
    private ResourceService resourceService;

    public CsvServiceImpl(final ResourceService resourceService)
    {
        this.resourceService = resourceService;
    }

    @Override
    public CSVReader getCsvReader()
    {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new BufferedReader(new InputStreamReader(resourceService.getCsvURL().openStream())));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return csvReader;
    }

    @Override
    public List<Quiz> getQuizList()
    {
        List<Quiz> beans = null;
        try {
            beans = new CsvToBeanBuilder<Quiz>(new BufferedReader(new InputStreamReader(resourceService.getCsvURL().openStream())))
                    .withType(Quiz.class).build().parse();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return beans;
    }
}
