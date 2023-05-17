package ru.myitschool.lesson20221216_1;

public class Question extends Unit{
    private final String name;
    private final Answers[] answers;

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

    public Question(String name, Answers[] answers) {
        this.name = name;
        this.answers = answers;
    }




}
