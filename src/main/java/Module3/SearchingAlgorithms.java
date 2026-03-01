package Module3;

public class SearchingAlgorithms {

    public static int linearsearch(int [] arr, int key) {
        for(int i=0; i< arr.length; i++ ) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void linearSearch(int[] arr, int key) {
    }
}


