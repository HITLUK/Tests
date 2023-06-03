package ru.myitschool.lesson20221216_1;


public class Question extends Unit {
    private static int id;
    private final int balls;
    private final String name;
    private final Answers[] answers;
    @Override
    public int getBalls() {
        return balls;
    }

    public int getId() {
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

    public Question(int balls, String name, Answers[] answers,int id) {
        this.balls = balls;
        this.name = name;
        this.answers = answers;
        this.id = id;
    }




}
