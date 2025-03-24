import java.util.Arrays;

//a class to handle the results of a quiz
public class Results {
    //a static list of possible countries
    public static String[] countries = {"Germany", "Lithuania", "Poland", "France", "Ukraine", "Italy", "Netherlands"};
    
    //takes a quiz and sorts the countries by how close of a match each one is
    public static SortElement[] getSortedResults(Quiz quiz) {
        //start with the list of ints
        int[] rawList = quiz.getResult();
        SortElement[] rawElementList = new SortElement[rawList.length];
        //make all SortElement objects
        for (int i = 0; i < rawList.length; i++) {
            rawElementList[i] = new SortElement(countries[i], rawList[i]);
        }
        SortElement[] sortedList = sort(rawElementList);
        return sortedList;
    }
    //merge sort algorithm
    public static SortElement[] sort(SortElement[] arr) {
        //recursively split up the array until it is a single element and then merge the sorted elements
        if(arr.length>1) {
            int mid = arr.length/2;
            return merge(sort(Arrays.copyOfRange(arr, 0, mid)), sort(Arrays.copyOfRange(arr, mid, arr.length)));
        }
        else
        {
            return arr;
        }
        
    }
    //go element by element to merge two already sorted arrays
    private static SortElement[] merge(SortElement[] left, SortElement[] right)
    {
        SortElement[] output = new SortElement[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < output.length; i++)
        {
            if (leftIndex < left.length && rightIndex < right.length)
            {
                if (left[leftIndex].value >= right[rightIndex].value)
                {
                    output[i] = left[leftIndex];
                    leftIndex++;
                }
                else
                {
                    output[i] = right[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex >= left.length)
            {
                output[i] = right[rightIndex];
                rightIndex++;
            }
            else
            {
                output[i] = left[leftIndex];
                leftIndex++;
            }
        }
        return output;
    }
}