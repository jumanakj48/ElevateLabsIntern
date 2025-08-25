package com.quizapp;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswer; // 0-based index

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean isCorrect(int answer) {
        return (answer - 1) == correctAnswer;
    }
}
