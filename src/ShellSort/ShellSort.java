package ShellSort;

import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/18.
 */
public class ShellSort {
    private static void shellsort(int a[], int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < n; j += gap) {
                    if (a[j] < a[j - gap]) {
                        int tmp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > tmp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = tmp;
                    }
                }
            }
        }
    }

    public static void groupSort(int[] a, int n, int i, int gap) {

        for (int j = i + gap; j < n; j += gap) {

            // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
            if (a[j] < a[j - gap]) {

                int tmp = a[j];
                int k = j - gap;
                while (k >= 0 && a[k] > tmp) {
                    a[k + gap] = a[k];
                    k -= gap;
                }
                a[k + gap] = tmp;
            }
        }
    }

    /**
     * 希尔排序
     * <p>
     * 参数说明：
     * a -- 待排序的数组
     * n -- 数组的长度
     */
    public static void shellSort2(int[] a, int n) {
        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++)
                groupSort(a, n, i, gap);
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
        System.out.println("Please input n:");
        int n = sc.nextInt();
        shellsort(num,num.length);
        //shellSort2(num, n);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
