package org.example;

import Module3.BinarySearchTree;
import Module3.PerformanceAnalyzer;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("TO DO MODULE 1 ");
                    break;

                case 2:
                    System.out.print("TO DO MODULE 2 ");
                    break;

                case 3:
                    runModule3(sc);
                    //System.out.print("TO DO Module 3");
                    break;

                case 4:
                    System.out.print("Exit...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }


        } while (choice != 4);
        sc.close();
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
                System.out.print("Enter two numbers: ");
                break;
        }



    }

}
