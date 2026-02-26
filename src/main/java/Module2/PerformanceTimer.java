package Module2;

public class PerformanceTimer {

    public static long measureBubble(int[] arr) {

        int[] copy = arr.clone();

        long start = System.nanoTime();
        BubbleSort.sort(copy);
        long end = System.nanoTime();

        return end - start;
    }

    public static long measureMerge(int[] arr) {

        int[] copy = arr.clone();

        long start = System.nanoTime();
        MergeSort.sort(copy, 0, copy.length - 1);
        long end = System.nanoTime();

        return end - start;
    }

    public static long measureQuick(int[] arr) {

        int[] copy = arr.clone();

        long start = System.nanoTime();
        QuickSort.sort(copy, 0, copy.length - 1);
        long end = System.nanoTime();

        return end - start;
    }
}