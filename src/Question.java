import java.security.InvalidParameterException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question extends JOptionPane {
    //instance variables
    String question;
    Answer[] answers;
    //java swing elements
    JComboBox<String> options;
    //Java swing main panel
    JPanel main;

    public Question(String question, Answer[] answers) {
        super();
        main = new JPanel(new GridLayout(2,1));
        //add the question at the top
        add(new JTextArea(question));
        //add all options
        options = new JComboBox<String>();
        for (int i = 0; i < answers.length; i++) {
            options.addItem(answers[i].getText());
        }
        add(options);
        this.question = question;
        this.answers = answers;
    }
    
    public int[] ask(JFrame parent) {
        showMessageDialog(parent,main);
        return answers[options.getSelectedIndex()].getResult();
    }
    
}
