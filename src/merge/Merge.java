package merge;

import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/18.
 */
public class Merge {
    //递归分成小部分
    private static void merge_sort(int[] arrays, int start, int end) {
        if (start < end) {
            int m = (start + end) / 2;
            merge_sort(arrays, start, m);
            merge_sort(arrays, m + 1, end);
            combin_arrays(arrays, start, m, end);
        }
    }

    //合并数组
    private static void combin_arrays(int[] arrays, int start, int m, int end) {
        int length = end - start + 1;
        int temp[] = new int[length];//用来存放比较的数组，用完复制回到原来的数组
        int i = start;
        int j = m + 1;
        int c = 0;
        while (i <= m && j <= end) {
            if (arrays[i] < arrays[j]) {
                temp[c] = arrays[i];
                i++;
                c++;
            } else {
                temp[c] = arrays[j];
                j++;
                c++;
            }
        }
        while (i <= m) {
            temp[c] = arrays[i];
            i++;
            c++;
        }
        while (j <= end) {
            temp[c] = arrays[j];
            j++;
            c++;
        }
        c = 0;
        for (int t = start; t <= end; t++, c++) {
            arrays[t] = temp[c];
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
        merge_sort(num, 0, num.length - 1);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
