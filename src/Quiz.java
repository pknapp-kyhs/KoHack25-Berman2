//quiz class, will contain code to open window and load questions
import javax.swing.*;

public class Quiz extends JWindow{
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
    }

    //a method to run the quiz program
    public void run() {
        for (Question question: questions) {
            ask(question);
            
        }
    }

    //a method to ask one question
    public int[] ask(Question question) {
        return new int[RESOLUTION];
    }

}