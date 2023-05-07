package ru.myitschool.lesson20221216_1;

public class Quest {
    private int score = 0;
    private int currentStep = 0;

    private  Question[] questions = new Question[]{
            new Question("Первый вопрос",
                    new Question.Answers[]{
                            new Question.Answers("+100 баллов", 100, 1),
                            new Question.Answers("+1000 баллов", 1000, -1)
                    }),
            new Question("Второй вопрос",
                    new Question.Answers[]{
                            new Question.Answers("-100 баллов", -1, 0),
                            new Question.Answers("-100 баллов", 50, 1),
                            new Question.Answers("-10 баллов", -10, -2)
                    })
            ,
            new Question("Третий вопрос",
                    new Question.Answers[]{
                            new Question.Answers("-100 баллов", +100, 0),
                            new Question.Answers("-10 баллов", -10, -1)
                    })

    };


    public void addScore(int score) {
        this.score += score;
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.length)
            return questions[index];
        return null;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public static class Question {
        private final String description;
        private final Answers[] answers;

        public String getDescription() {
            return description;
        }

        public Answers[] getAnswers() {
            return answers;
        }

        public Question(String description, Answers[] answers) {
            this.description = description;
            this.answers = answers;
        }

        public static class Answers {
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
    }


}
