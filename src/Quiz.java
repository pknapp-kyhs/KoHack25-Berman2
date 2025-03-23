//quiz class, will contain code to open window and load questions
import javax.swing.*;

public class Quiz extends JFrame{
    //the number of result locations allowed
    public static final int RESOLUTION = 5;
    //contains an array of questions to ask
    Question[] questions;
    //contains an array of numbers representing the result
    int[] result;

    public Quiz(Question[] questions) {
        super();
        this.questions = questions;
        this.result = new int[RESOLUTION];
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //a method to run the quiz program
    public void run() {
        setVisible(true);
        for (Question question: questions) {
            addResult(ask(question));
        }
        System.out.println(result);
    }

    //a method to ask one question
    public int[] ask(Question question) {
        return question.ask(this);
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
}