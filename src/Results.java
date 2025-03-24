import java.util.Arrays;

public class Results {

    String[] countries = {"Germany", "Lithuania", "Poland", "France", "Ukraine", "Italy", "Netherlands"};
    public static String[] getDisplayResults(int numResults, Quiz quiz)
    {
        int[] rawList = quiz.getResult();
        int[] sortedList = sort(rawList);
        return null;
    }
    public static int[] sort(int[] arr)
    {
        if(arr.length>1)
        {
            int mid = arr.length/2;
            return merge(sort(Arrays.copyOfRange(arr, 0, mid)), sort(Arrays.copyOfRange(arr, mid, arr.length)));
        }
        else
        {
            return arr;
        }
        
    }
    private static int[] merge(int[] left, int[] right)
    {
        int[] output = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < output.length; i++)
        {
            if (leftIndex < left.length && rightIndex < right.length)
            {
                if (left[leftIndex] <= right[rightIndex])  // ascending sort
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