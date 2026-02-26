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

        System.out.println("Numbers are:");
        for(int num : numbers) {
            System.out.print(num + " ");
        }
    }
}