import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class App {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        run();
    }
    public static void run() {
        Quiz quiz = new Quiz(DataReader.getEveryQuestion().toArray(new Question[0]));
        quiz.run();
        ResultDisplay display = new ResultDisplay(quiz);
    }
}
