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

    public static int[] copyArray(int [] OrginalArray){
        int [] copyofArray = new int[OrginalArray.length];
        System.arraycopy(OrginalArray,0,copyofArray,0,OrginalArray.length);
        return copyofArray;
    }

    public static void main(String[] args){

        int [] sizes = {100,500,1000};





    }






}
