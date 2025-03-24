//a class to hold a potential answer to a question
public class Answer {
    int[] result;
    String text;
    
    public Answer(int[] result, String text) {
        //checks parameter validity
        if (result.length != Quiz.RESOLUTION) {
            throw new IllegalArgumentException("Question modifier is wrong length");
        }
        this.text = text;
        this.result = result;
    }

    //Returns the text of the answer
    public String getText() {
        return text;
    }
    //returns the weight values of this answer. This is an array of ints. Each int represents a different country.
    public int[] getResult() {
        return result;
    }
    public String toString() {
        return text;
    }
}
