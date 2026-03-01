package Module3;


import java.util.Random;

public class PerformanceAnalyzer {

    public static int[] ArrayCreate(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i =0; i<size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }


}
