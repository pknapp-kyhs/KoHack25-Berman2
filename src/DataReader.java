import java.io.File;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DataReader{
    private static File dataFile = new File("Data.txt");
    
    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            //do nothing
        }
    }
    //gets raw text results from data file
    public static ArrayList<String> getRawResults()
    {
        ArrayList<String> rawResults = new ArrayList<String>();
        while(scanner.hasNextLine())
        {
            rawResults.add(scanner.nextLine());
        }
        return rawResults;
    }
    public static ArrayList<String> getQuestionText(ArrayList<String> data)
    {
        ArrayList<String> questionList = new ArrayList<String>();
        for(int i = 0; i < data.size(); i++)
        {
            questionList.add(data.get(i).substring(0,data.get(i).indexOf("?")));
        }
        return questionList;
    }
    private String getJustAnswer(String data)
    {
        return data.substring(data.indexOf("?")+1, data.length());
    }
    
}