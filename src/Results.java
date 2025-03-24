import java.util.Arrays;

public class Results {

    public static String[] countries = {"Germany", "Lithuania", "Poland", "France", "Ukraine", "Italy", "Netherlands"};
    public static String[] getDisplayResults(int numResults, Quiz quiz) {
        int[] rawList = quiz.getResult();
        SortElement[] rawElementList = new SortElement[rawList.length];
        for (int i = 0; i < rawList.length; i++) {
            rawElementList[i] = new SortElement(countries[i], rawList[i]);
        }
        SortElement[] sortedList = sort(rawElementList);
        
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