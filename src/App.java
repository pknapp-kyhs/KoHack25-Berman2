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
        SortElement[] elements = Results.getSortedResults(quiz);
        JFrame frame = new JFrame("Output");
        Map map = new Map("resources/europe.svg");
        map.setColors(elements);
        frame.add(map);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
