package Prim;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/19.
 */
public class MyPrim {
    private char[] mVexs;
    private int[][] mMatrix;
    private static final int INF = Integer.MAX_VALUE;

    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private char readChar() {
        char ch = '0';
        do {
            try {
                ch = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')));
        return ch;
    }

    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++)
            if (mVexs[i] == ch)
                return i;

        return -1;
    }

    public MyPrim() {
        System.out.printf("Please input vertex number");
        int vlen = readInt();
        System.out.printf("Please input edge number:");
        int elen = readInt();
        if (vlen < 1 || elen < 1 || (elen > (vlen * (vlen - 1)))) {
            System.out.printf("input error:invalid parameters!\n");
            return;
        }
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d)", i);
            mVexs[i] = readChar();
        }
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (i == j)
                    mMatrix[i][j] = 0;
                else
                    mMatrix[i][j] = INF;
            }
        }
        for (int i = 0; i < elen; i++) {
            System.out.printf("edge(%d):", i);
            char c1 = readChar();
            char c2 = readChar();
            int weight = readInt();
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            if (p1 == -1 || p2 == -1) {
                System.out.printf("input error:invalid edge!\n");
                return;
            }
            mMatrix[p1][p2] = weight;
            mMatrix[p2][p1] = weight;
        }

    }

    public void prim(int start) {
        int num = mVexs.length;
        int index = 0;
        char[] prims = new char[num];
        int[] weights = new int[num];
        prims[index++] = mVexs[start];
        for (int i = 0; i < num; i++)
            weights[i] = mMatrix[start][i];
        weights[start] = 0;
        for (int i = 0; i < num; i++) {
            if (start == i)
                continue;
            int j = 0;
            int k = 0;
            int min = INF;
            while (j < num) {
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }
            prims[index++] = mVexs[k];
            weights[k] = 0;
            for (j = 0; j < num; j++) {
                if (weights[j] != 0 && mMatrix[k][j] < weights[j])
                    weights[j] = mMatrix[k][j];
            }
        }
        int sum = 0;
        for (int i = 0; i < index; i++) {
            int min = INF;
            int n = getPosition(prims[i]);
            for (int j = 0; j < i; j++) {
                int m = getPosition(prims[j]);
                if (mMatrix[m][n] < min)
                    min = mMatrix[m][n];
            }
            sum += min;
        }
        System.out.printf("PRIM(%c)=%d:", mVexs[start], sum);
        for (int i = 0; i < index; i++)
            System.out.printf("%c", prims[i]);
        System.out.printf("\n");
    }

    public static void main(String args[]) {
        MyPrim myPrim = new MyPrim();
        myPrim.prim(0);
    }
}
