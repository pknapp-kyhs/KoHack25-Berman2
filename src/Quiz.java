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
        //starts with 0s, will be filled in as quiz goes on
        this.result = new int[RESOLUTION];
    }

    //a method to run the quiz program
    public void run() {
        //iterates through questions
        for (Question question: questions) {
            //asks question, then adds its value to the result
            addResult(question.ask());
        }
    }

    //adds the result of a question to the running total
    public void addResult(int[] qResult) {
        //check to make sure the array to be added is the same length as the instance variable array
        if (qResult.length != this.result.length) {
            throw new IllegalArgumentException("Cannot add mismatched arrays");
        }
        //iterates through values, and ads them
        for (int i = 0; i < this.result.length; i++) {
            this.result[i] += qResult[i];
        }
    }

    public int[] getResult() {
        return result;
    }
}