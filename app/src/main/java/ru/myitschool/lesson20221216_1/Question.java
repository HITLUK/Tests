package ru.myitschool.lesson20221216_1;

public class Question extends Unit{
    private final int balls;
    private final String name;
    private final Answers[] answers;

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Answers[] getAnswers() {
        return answers;
    }

    @Override
    public String Speak() {
        return "Question";
    }

    public Question(int balls, String name, Answers[] answers) {
        this.balls = balls;
        this.name = name;
        this.answers = answers;
    }




}
