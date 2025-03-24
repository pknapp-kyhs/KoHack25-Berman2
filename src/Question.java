import javax.swing.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class Question extends JOptionPane {
    //instance variables
    String question;
    Answer[] answers;
    //sets up the icon used in the questions
    static ImageIcon icon;
    static {
        ImageIcon bigIcon = new ImageIcon("resources/logo.png");
        Image bigImage = bigIcon.getImage();
        Image smallImage = bigImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        icon = new ImageIcon(smallImage);


    }

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
        //makes an icon to use in the question popup
        ImageIcon bigIcon = new ImageIcon("resources/logo.png");
        return answers[showOptionDialog(null,question,"Question",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,icon,answers,0)].getResult();
    }
}