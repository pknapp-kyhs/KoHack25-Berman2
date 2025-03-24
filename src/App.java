import javax.swing.UIManager;

public class App {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        run();
    }
    public static void run() {
        //Feature 1: Read in data and initialize quiz
        Quiz quiz = new Quiz(DataReader.getEveryQuestion().toArray(new Question[0]));
        //Feature 2: run quiz
        quiz.run();
        //Feature 3: process and display output
        ResultDisplay display = new ResultDisplay(quiz);
        display.start();
    }
}