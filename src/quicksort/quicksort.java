package quicksort;

import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/18.
 */
public class Quicksort {
    private static void quicksort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quicksort(s, l, i - 1); // 递归调用
            quicksort(s, i + 1, r);
        }
    }

    public static void main(String args[]) throws ArrayIndexOutOfBoundsException{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串整数并在输入时用英文逗号隔开：");
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(",");
        int num[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            num[i] = Integer.parseInt(stringArray[i]);
        }
        int numlength = num.length;
        System.out.println(num[0] + " " + num[numlength-1]);
        quicksort(num, 0, numlength-1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }


    }
}
