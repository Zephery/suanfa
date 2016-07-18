package com;

import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/18.
 */
public class BinarySearch {
    static int BinarySearch(int Array[], int low, int high, int key) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (key == Array[mid])
                return mid+1;
            else if (key < Array[mid]) {
                return BinarySearch(Array, low, mid, key);
            } else
                return BinarySearch(Array, mid, high, key);
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串整数并在输入时用英文逗号隔开：");
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(",");
        int num[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            num[i] = Integer.parseInt(stringArray[i]);
            System.out.print(num[i] + " ");
        }
        System.out.println("\nPlease input the number you want:");
        int key = sc.nextInt();
        System.out.println(BinarySearch(num, 0, num.length, key));
    }
}
