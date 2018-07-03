package com.otus.spring.main;

import com.otus.spring.service.CsvService;
import com.otus.spring.service.QuizService;
import com.otus.spring.service.impl.QuizServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main(String[] args)
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        CsvService csvService = context.getBean(CsvService.class);

        QuizService quizService = new QuizServiceImpl(csvService);
        quizService.run();
    }
}
