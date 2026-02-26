package Module2;

import java.util.*;

public class TestInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numbers;

        System.out.println("1. Enter Numbers");
        System.out.println("2. Generate Random Numbers");

        System.out.print("Choose option: ");
        int choice = sc.nextInt();

        if(choice == 1) {
            numbers = DataInput.manualInput(sc);
        }
        else {
            numbers = DataInput.randomInput(sc);
        }


        long bubbleTime = PerformanceTimer.measureBubble(numbers);
        long mergeTime  = PerformanceTimer.measureMerge(numbers);
        long quickTime  = PerformanceTimer.measureQuick(numbers);

        System.out.println("\nExecution Times:");
        System.out.println("Bubble Sort : " + bubbleTime + " ns");
        System.out.println("Merge Sort  : " + mergeTime  + " ns");
        System.out.println("Quick Sort  : " + quickTime  + " ns");


        for(int num : numbers) {
            System.out.print(num + " ");
        }
    }
}