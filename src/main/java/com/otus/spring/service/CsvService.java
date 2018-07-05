package com.otus.spring.service;

import com.opencsv.CSVReader;
import com.otus.spring.domain.Quiz;

import java.util.List;

public interface CsvService
{
    List<Quiz> getQuizList();
}
