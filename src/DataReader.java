import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DataReader{
    private File dataFile = new File("Data.txt");
    private Scanner scanner = new Scanner(dataFile);

    //gets raw text results from data file
    public ArrayList<String> getRawResults()
    {
        ArrayList<String> rawResults = new ArrayList<String>();
        while(scanner.hasNextLine)
        {
            rawResults.add(scanner.nextLine());
        }
        return rawResults;
    }
    public ArrayList<Question> getQuestions(ArrayList<String> data)
    {
        ArrayList<String> questionList = new ArrayList<String>();
        for(int i = 0; i < data.size(); i++)
        {
            questionList.add(data.get(i).substring(0,indexOf("?")));
        }
        
    }
    public String getJustAnswer(String data)
    {
        return data.substring(indexOf("?")+1, data.length());
    }
    
}