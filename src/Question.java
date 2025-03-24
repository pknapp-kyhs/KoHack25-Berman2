import javax.swing.*;

public class Question extends JOptionPane {
    //instance variables
    String question;
    Answer[] answers;

    public Question(String question, Answer[] answers) {
        super();
        if (question == null || answers == null || answers.length <= 0) {
            //debugging and error handling
            throw new IllegalArgumentException("Invalid Constructor inputs");
        }
        this.question = question;
        this.answers = answers;
    }
    
    //asks the question
    public int[] ask() {
        //returns the array of ints from the chosen answer
        return answers[showOptionDialog(null,question,"Question",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,answers,0)].getResult();
    }
}
