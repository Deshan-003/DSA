package org.example;
import Module3.BinarySearchTree;
import Module3.PerformanceAnalyzer;
import Module3.SearchingAlgorithms;
import Module3.SortingAlgorithms;
import Module2.TestInput;
import Module1.RoutePlanner;

import java.util.Scanner;

import static Module3.PerformanceAnalyzer.ArrayCreate;
import static Module3.PerformanceAnalyzer.copyArray;
//Scanner scanner = new Scanner(System.in);
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // declare scanner here
        int choice;

        do{
            //System.out.println("-------------------------------------");
            System.out.println("-------------Menu---------------");
            //System.out.println("-------------------------------------");
            System.out.println("1. Module 1- Smart City Planner");
            System.out.println("2. Module 2- Data Sorter(Sorting Algorithms)");
            System.out.println("3. Module 3- Algorithm Performance Analyzer");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    RoutePlanner module1 = new RoutePlanner(scanner);
                    module1.run();
                    break;

                case 2:
                    TestInput.main(new String[]{});
                    break;

                case 3:
                    runModule3(scanner);
                    //System.out.print("TO DO Module 3");
                    break;

                case 4:
                    System.out.print("Exit...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }


        } while (choice != 4);
        scanner.close();
    }

    private static void runModule3(Scanner sc) {
        System.out.println("--------MODULE3 - MENU---------");
        System.out.println("1. BinarySearchTree.");
        System.out.println("2. PerformanceAnalyzer.");
        System.out.println("Enter your choice : ");

        int subchoice = sc.nextInt();

        switch (subchoice){
            case 1:


                BinarySearchTree tree = new BinarySearchTree();

                System.out.println("Enter Number Of Elements : ");
                int n = sc.nextInt();

                int[] arr = new int[n];

                for(int i=0; i< n; i++) {
                    System.out.println("Enter value"+(i+1)+":");
                    int value = sc.nextInt();
                    tree.insert(value);
                }

                System.out.println("Inorder travesel:");
                tree.inorder();

                int [] sortedarray = new int[n];
                tree.storeinArray(sortedarray);

                System.out.println("Values Soretd Array:");
                for (int num : sortedarray) {
                    System.out.println(num+"");
                }

                System.out.println();
                break;

            case 2:
                int[] sizes = {100, 500, 1000};

                System.out.printf("%-15s %-25s %-25s%n", "Input Size", "Linear Search (ns)", "Bubble Sort (ns)");
                System.out.println("=================================================================");

                for (int size : sizes) {


                    arr = ArrayCreate(size);


                    int[] arrForSort = copyArray(arr);

                    int key = arr[size - 1];


                    long startSearch = System.nanoTime();
                    SearchingAlgorithms.linearSearch(arr, key);
                    long endSearch = System.nanoTime();
                    long searchTime = endSearch - startSearch;


                    long startSort = System.nanoTime();
                    SortingAlgorithms.bubbleSort(arrForSort);
                    long endSort = System.nanoTime();
                    long sortTime = endSort - startSort;

                    System.out.printf("%-15d %-25d %-25d%n", size, searchTime, sortTime);
                }

                System.out.println("==============================================================");
                break;
        }



    }

}
