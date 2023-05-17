package ru.myitschool.lesson20221216_1;

public  class Answers {
    private final String name;
    private final int score;
    private final int nextStep;
    private boolean istrue = false;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getNextStep() {
        return nextStep;
    }

    public Answers(String name, int score, int nextStep) {
        this.name = name;
        this.score = score;
        this.nextStep = nextStep;
    }
}
