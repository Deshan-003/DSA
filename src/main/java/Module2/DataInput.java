package Module2;

import java.util.*;

public class DataInput {

    // Manual inputting
    public static int[] manualInput(Scanner sc) {
        System.out.print("Type number of elements: ");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("");
        System.out.println("Type the numbers:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }



    //Random inputting
    public static int[] randomInput(Scanner sc) {
        System.out.print("Enter number of elements: ");

        int n = sc.nextInt();

        int[] arr = new int[n];
        Random rand = new Random();

        for(int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }

        System.out.print("");
        System.out.println("Random numbers generated...");

        return arr;
    }


}