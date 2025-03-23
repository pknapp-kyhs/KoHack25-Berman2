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

    public String getText() {
        return text;
    }
    public int[] getResult() {
        return result;
    }
    public String toString() {
        return text;
    }
}
