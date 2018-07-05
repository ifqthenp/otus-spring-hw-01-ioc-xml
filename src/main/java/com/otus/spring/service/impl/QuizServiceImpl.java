package com.otus.spring.service.impl;

import com.otus.spring.domain.Quiz;
import com.otus.spring.service.CsvService;
import com.otus.spring.service.QuizService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizServiceImpl implements QuizService
{
    private CsvService csvService;
    private ArrayList<Integer> userAnswers;

    public QuizServiceImpl(final CsvService csvService)
    {
        this.csvService = csvService;
        this.userAnswers = new ArrayList<>();
    }

    @Override
    public void run()
    {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("\nPlease enter your name: ");
            String userName = in.nextLine();
            System.out.println("Hello " + userName + ", please read the question" +
                    "\nand select from the following options:");

            List<Quiz> quizList = csvService.getQuizList();

            for (Quiz q : quizList) {
                System.out.println("\n" + q.getQuestion());
                List<String> options = q.getOptions();

                int idx = 1;
                for (String option : options) {
                    System.out.println("Press " + idx + " for answer " + "\"" + option + "\"");
                    idx++;
                }
                System.out.print("Please make your choice: ");
                int input = in.nextInt();
                convertInputToScore(q, options.get(input - 1));
            }

            final int score = getTotalScore();
            System.out.println("\nYour score is " + score + " out of " + userAnswers.size());
        }
    }

    public int getTotalScore()
    {
        return userAnswers.stream().mapToInt(Integer::intValue).sum();
    }

    private void convertInputToScore(final Quiz quiz, final String input)
    {
        if (quiz.getAnswer().equals(input)) {
            userAnswers.add(1);
        } else {
            userAnswers.add(0);
        }
    }
}
