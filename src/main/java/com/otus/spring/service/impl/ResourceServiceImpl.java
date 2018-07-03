package com.otus.spring.service.impl;

import com.otus.spring.service.CsvUrlService;

import java.net.URL;

public class CsvUrlServiceImpl implements CsvUrlService
{
    private static final String CSV_RESOURCE = "quiz.csv";

    @Override
    public URL getCsvURL()
    {
        return getClass().getClassLoader().getResource(CSV_RESOURCE);
    }
}
