package Module2;

public class SortComparison {

    public static void showResults(int[] arr) {

        long bubbleTime = PerformanceTimer.measureBubble(arr);
        long mergeTime  = PerformanceTimer.measureMerge(arr);
        long quickTime  = PerformanceTimer.measureQuick(arr);

        System.out.println("\n--- Sorting Performance ---");
        System.out.println("Algorithm\t\tTime (ns)");
        System.out.println("----------------------------------");
        System.out.println("Bubble Sort\t\t" + bubbleTime);
        System.out.println("Merge Sort\t\t" + mergeTime);
        System.out.println("Quick Sort\t\t" + quickTime);
    }
}