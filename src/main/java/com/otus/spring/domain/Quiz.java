package com.otus.spring.domain;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class Quiz
{
    @CsvBindAndSplitByName(elementType = String.class, collectionType = ArrayList.class)
    private final List<String> options = new ArrayList<>();

    @CsvBindByName(column = "question")
    private String question;

    @CsvBindByName(column = "correct answer")
    private String answer;

    public List<String> getOptions()
    {
        return options;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(final String question)
    {
        this.question = question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(final String answer)
    {
        this.answer = answer;
    }

    @Override
    public String toString()
    {
        return "Quiz{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", options=" + options +
                '}';
    }
}
