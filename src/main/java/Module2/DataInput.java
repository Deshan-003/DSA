import java.util.*;

public class DataInput {

    //Manual inputing..
    public static int[] manualInput(Scanner sc) {
        system.out.println("Type number of elements: ");
        int n =sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Type the numbers: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}