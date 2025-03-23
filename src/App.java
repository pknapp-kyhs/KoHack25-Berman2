import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Question[] questions = new Question[0];
        Quiz quiz = new Quiz(DataReader.getEveryQuestion().toArray(questions));
        quiz.run();
    }
}
