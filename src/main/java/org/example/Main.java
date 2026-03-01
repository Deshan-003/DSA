package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("-------------------------------------");
            System.out.println("-------------Menu.....---------------");
            System.out.println("-------------------------------------");
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
                    System.out.print("TO DO Module 3");
                    break;

                case 4:
                    System.out.print("Exit...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }


        } while (choice != 5);
        sc.close();
    }

}
