
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] int1 = {1,0,0,0,0};
        Answer answer1 = new Answer(int1,"option 1");
        int[] int2 = {0,1,0,0,0};
        Answer answer2 = new Answer(int2,"option 2");
        int[] int3 = {0,0,1,0,0};
        Answer answer3 = new Answer(int3,"option 3");

        Answer[] answers = {answer1,answer2,answer3};
        Question test = new Question("test", answers);
        Question test2 = new Question("test2", answers);
        Question[] questions = {test, test2};
        Quiz quiz = new Quiz(questions);
        quiz.run();
    }
}
