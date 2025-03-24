import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {5,10,4,8,3};
        int[] sorted = Results.sort(arr);
        for(int i : sorted)
        {
            System.out.println(i);
        }
    }
}
