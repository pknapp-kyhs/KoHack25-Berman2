import java.security.InvalidParameterException;

import javax.swing.*;

public class Question extends JPanel {
    //maximum options per question
    public static final int MAX_OPTIONS = 4;
    String question;
    Answer[] answers;

    public Question(String question, Answer[] answers) {
        if (answers.length > MAX_OPTIONS) {
            throw new InvalidParameterException("Too many options in this question");
        }
        this.question = question;
        this.answers = answers;
    }    
}
