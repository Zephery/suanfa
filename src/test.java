/**
 * Created by Zephery on 2016/7/19.
 */
public class test {
    public static void main(String args[]) {
        int a[] = {1, 24, 2, 7, 45, 34, 53, 53};
        int k=0;
        for (int i = 0; i < a.length; i++) {
            k = a[i]++;
        }
        System.out.println(k);
    }
}
