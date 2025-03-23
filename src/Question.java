import java.security.InvalidParameterException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question extends JOptionPane {
    //instance variables
    String question;
    Answer[] answers;
    //Java swing main panel
    JPanel main;

    public Question(String question, Answer[] answers) {
        super();
        main = new JPanel(new GridLayout(2,1));
        //add the question at the top
        add(new JTextArea(question));
        //add all options
        this.question = question;
        this.answers = answers;
    }
    
    public int[] ask(JFrame parent) {
        return answers[showOptionDialog(parent,question,"Question",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,answers,0)].getResult();
    }

}
