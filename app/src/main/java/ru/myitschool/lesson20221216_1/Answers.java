package ru.myitschool.lesson20221216_1;

public  class Answers {
    private final String name;
    private final int score;
    private final int nextStep;
    private final boolean isreal;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getNextStep() {
        return nextStep;
    }

    public boolean isIsreal() {
        return isreal;
    }

    public Answers(String name, int score, int nextStep, boolean isreal) {
        this.name = name;
        this.score = score;
        this.nextStep = nextStep;
        this.isreal = isreal;
    }
}
