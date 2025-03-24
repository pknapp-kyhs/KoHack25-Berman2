import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Question[] questions = new Question[0];
        Quiz quiz = new Quiz(DataReader.getEveryQuestion().toArray(questions));
        quiz.run();

        JFrame frame = new JFrame("Result");
        Map panel = new Map("europe.svg");
        panel.changeRegionColor("DE", Color.RED);
        panel.repaint();
        frame.add(panel);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
