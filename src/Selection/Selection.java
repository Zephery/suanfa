package Selection;

import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/18.
 */
public class Selection {
    static void sort(int Array[]) {
        int N = Array.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Array[j] < Array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = Array[i];
                Array[i] = Array[min];
                Array[min] = temp;
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串整数并在输入时用英文逗号隔开：");
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(",");
        int num[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            num[i] = Integer.parseInt(stringArray[i]);
        }
        sort(num);
        System.out.println("选择排序：");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}