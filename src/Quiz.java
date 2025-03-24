//quiz class, will contain code to open window and load questions

public class Quiz {
    //the number of result locations allowed
    public static final int RESOLUTION = 7;
    //contains an array of questions to ask
    Question[] questions;
    //contains an array of numbers representing the result
    int[] result;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.result = new int[RESOLUTION];
    }

    //a method to run the quiz program
    public void run() {

        for (Question question: questions) {
            addResult(ask(question));
        }
    }

    //a method to ask one question
    public int[] ask(Question question) {
        return question.ask();
    }

    //adds the result of a question to the running total
    public void addResult(int[] qResult) {
        if (qResult.length != result.length) {
            throw new IllegalArgumentException("Cannot add mismatched arrays");
        }
        for (int i = 0; i < result.length; i++) {
            result[i] += qResult[i];
        }
    }

    public int[] getResult()
    {
        return result;
    }
}