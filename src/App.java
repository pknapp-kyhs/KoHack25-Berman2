
public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {0,5,7,10,4,3};

        
        int[] result = Results.sort(arr);
        for(int i : result)
        {
            System.out.println(i);
        }
    }
}
