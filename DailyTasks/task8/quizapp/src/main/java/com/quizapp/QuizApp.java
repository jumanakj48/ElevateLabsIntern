package com.quizapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = loadQuestions("questions.json");

        if (questions == null || questions.isEmpty()) {
            System.out.println("No questions found!");
            return;
        }

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            questions.get(i).displayQuestion();

            System.out.print("Your answer (1-" + questions.get(i).getOptions().size() + "): ");
            int userAnswer = sc.nextInt();

            if (questions.get(i).isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + 
                                   questions.get(i).getOptions().get(questions.get(i).getCorrectAnswer()));
            }
        }

        System.out.println("\nQuiz Over!");
        System.out.println("Your final score: " + score + "/" + questions.size());
        sc.close();
    }

    // Load questions from JSON file
    private static List<Question> loadQuestions(String filename) {
        try {
            // Load file from classpath
            ClassLoader classLoader = QuizApp.class.getClassLoader();
            try (Scanner scanner = new Scanner(classLoader.getResourceAsStream(filename))) {
                StringBuilder json = new StringBuilder();
                while (scanner.hasNextLine()) {
                    json.append(scanner.nextLine());
                }
                Gson gson = new Gson();
                Type questionListType = new TypeToken<List<Question>>() {}.getType();
                return gson.fromJson(json.toString(), questionListType);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
