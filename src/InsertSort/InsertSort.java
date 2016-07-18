package InsertSort;

import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/18.
 */
public class InsertSort {
    private static void Insertsort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int currentvalue = array[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > currentvalue) {
                    array[j + 1] = array[j];
                    position -= 1;
                } else {
                    break;
                }
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
        Insertsort(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
