package merge;

import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/18.
 */
public class Merge {
    private static void mergesort(int array[],int start,int end){

        System.out.println(start+end);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串整数并在输入时用英文逗号隔开：");
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(",");
        int num[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            num[i] = Integer.parseInt(stringArray[i]);
        }
        mergesort(num,num[0],num[num.length-1]);

    }
}
