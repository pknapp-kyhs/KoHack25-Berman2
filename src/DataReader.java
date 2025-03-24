import java.io.File;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DataReader{
    private static File dataFile = new File("resources/questions.txt");
    
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
    //input the whole line of raw data and get just the question text
    public static String getQuestionText(String data)
    {
        //ArrayList<String> questionList = new ArrayList<String>();
        //for(String line : data)
        //{
        //    questionList.add(line.substring(0,line.indexOf("?")+1));
        //}
        return data.substring(0,data.indexOf("?")+1);
    }
    //input the whole line of data and get just the answers part
    private static String getJustAnswer(String data)
    {
        return data.substring(data.indexOf("?")+1);
    }

    //overly compact function to turn a string in the format answer:intintintintint to an answer object
    public static Answer stringToAnswer(String data) {
        return new Answer(convertStringToNumbers(data.substring(data.indexOf(":") + 1)), data.substring(0, data.indexOf(":")));
    }
    //input just the answers of a line in the text file and get an array of answer objects
    public static Answer[] getAnswerArray(String data)
    {
        //split the whole line around the ";" charachter
        String[] answerStrings = data.split(";");
        //turn each string into an answer object
        Answer[] output = new Answer[answerStrings.length];

        for (int i = 0; i < answerStrings.length; i++) {
            output[i] = stringToAnswer(answerStrings[i]);
        }

        return output;
    }
    //converts a string of a bunch of numbers and turns it into an array of ints
    private static int[] convertStringToNumbers(String numberString)
    {
        int[] output = new int[numberString.length()];
        for(int i = 0; i < numberString.length(); i++)
        {
            output[i] = Integer.parseInt(numberString.substring(i, i+1));
        }
        return output;
    }
    //inputs a single line of raw data and returns a question object corresponding to that line
    public static Question getQuestionObject(String lineOfRawData)
    {
        return new Question(getQuestionText(lineOfRawData), getAnswerArray(getJustAnswer(lineOfRawData)));
    }
    
    //returns all questions in object form
    public static ArrayList<Question> getEveryQuestion() {
        //an arrayList of strings representing one question each
        ArrayList<String> rawResults = getRawResults();
        ArrayList<Question> output = new ArrayList<Question>();
        for(String line: rawResults) {
            output.add(getQuestionObject(line));
        }
        return output;
    }
}