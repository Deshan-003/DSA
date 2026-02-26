package Module2;

import java.util.*;

public class DataInput {

    // Manual inputting
    public static int[] manualInput(Scanner sc) {
        System.out.print("Type number of elements: ");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Type the numbers:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }


}