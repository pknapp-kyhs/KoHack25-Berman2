import java.security.InvalidParameterException;

import javax.swing.*;
import java.awt.*;

public class Question extends JPanel {
    //maximum options per question
    public static final int MAX_OPTIONS = 5;
    String question;
    Answer[] answers;

    public Question(String question, Answer[] answers) {
        super(new GridLayout(MAX_OPTIONS + 1,1));
        if (answers.length > MAX_OPTIONS) {
            throw new InvalidParameterException("Too many options in this question");
        }
        //add the question at the top
        add(new JTextArea(question));
        JC
        for (int i = 0; i < MAX_OPTIONS; i++) {
            
        }
        this.question = question;
        this.answers = answers;
    }
    
    public int[] ask() {

    }

    private void build() {

    }
}
