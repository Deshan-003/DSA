package Module3;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BinarySearchTree {

    class node{
        int data;
        node left, right;

        node(int value) {
            data = value;
            left = right = null;
        }
    }

    node root;
    public int index = 0;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    public node insertRec(node root, int value) {
        if(root == null) {
            return new node(value);
        }

        if ( value < root.data) {
            root.left = insertRec(root.left,value);
        } else if (value > root.data) {
            root.right = insertRec(root.right,value);
        }

        return root;

    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    public void inorderRec(node root) {
        if(root != null) {
            inorderRec(root.left);
            System.out.println(root.data+"");
            inorderRec(root.right);
        }
    }

    public void storeinArray(int[] arr){
        index = 0;
        storeinorder(root,arr);
    }

    public void storeinorder(node root, int[] arr) {
        if(root != null) {
            storeinorder(root.left,arr);
            arr[index++] = root.data;
            storeinorder(root.right,arr);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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











    }
















}
