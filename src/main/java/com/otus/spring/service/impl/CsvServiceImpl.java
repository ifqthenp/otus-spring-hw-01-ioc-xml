package com.otus.spring.service.impl;

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
    public List<Quiz> getQuizList()
    {
        List<Quiz> beans = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceService.getCsvURL().openStream()))) {
            beans = new CsvToBeanBuilder<Quiz>(br).withType(Quiz.class).build().parse();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return beans;
    }
}
