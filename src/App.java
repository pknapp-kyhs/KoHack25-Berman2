
public class App {
    public static void main(String[] args) throws Exception {
        System.out.print(DataReader.getRawResults());
        System.out.print(DataReader.getQuestions(DataReader.getRawResults()));
    }
}
