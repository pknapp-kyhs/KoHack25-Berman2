import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Question> questionsList = DataReader.getEveryQuestion();
        Question[] questions = new Question[questionsList.size()];
        questionsList.toArray(questions);
        Quiz quiz = new Quiz(DataReader.getEveryQuestion().stream().toArray());
        quiz.run();
    }
}
