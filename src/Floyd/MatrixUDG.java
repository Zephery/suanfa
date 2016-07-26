package Floyd;

import com.algs4.stdlib.In;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/26.
 */
public class MatrixUDG {
    private int mEdgNum;
    private char[] mVexs;
    private int[][] mMatrix;
    private static final int INF = Integer.MAX_VALUE;

    private char readChar() {
        char ch = '0';
        do {
            try {
                ch = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!((ch >= 'a' && ch < 'z') || (ch >= 'A' && ch <= 'Z')));
        return ch;
    }

    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++)
            if (mVexs[i] == ch)
                return i;
        return -1;
    }

    public MatrixUDG() {
        System.out.printf("Input vertex number:");
        int vlen = readInt();
        System.out.printf("Input edge number:");
        int elen = readInt();
        if (vlen < 1 || elen < 1 || (elen > (vlen * (vlen - 1)))) {
            System.out.printf("Input error: invalid parameters!\n");
            return;
        }
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d):", i);
            mVexs[i] = readChar();
        }
        mEdgNum = elen;
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

    public MatrixUDG(char[] vexs, int[][] matrix) {
        int vlen = vexs.length;
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = vexs[i];
        }
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];
        mEdgNum = 0;
        for (int i = 0; i < vlen; i++)
            for (int j = i + 1; j < vlen; j++)
                if (mMatrix[i][j] != INF)
                    mEdgNum++;
    }

    private int firstVertex(int v) {
        if (v < 0 || v > (mVexs.length - 1))
            return -1;
        for (int i = 0; i < mVexs.length; i++) {
            if (mMatrix[v][i] != 0 && mMatrix[v][i] != INF)
                return i;
        }
        return -1;
    }

    private int nextVertex(int v, int w) {
        if (v < 0 || v > (mVexs.length - 1) || w < 0 || w > (mVexs.length - 1))
            return -1;
        for (int i = w + 1; i < mVexs.length; i++) {
            if (mMatrix[v][i] != 0 && mMatrix[v][i] != INF)
                return i;
        }
        return -1;
    }

    private void DFS(int i, boolean[] visited) {
        visited[i] = true;
        System.out.printf("%c", mVexs[i]);
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w))
            if (!visited[w])
                DFS(w, visited);
    }

    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];
        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;
        System.out.printf("DFS:");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        System.out.printf("\n");
    }

    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];
        boolean[] visited = new boolean[mVexs.length];
        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;
        System.out.printf("BFS:");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%c", mVexs[i]);
                queue[rear++] = i;
            }
            while (head != rear) {
                int j = queue[head++];
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) {
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%c", mVexs[k]);
                        queue[rear++] = k;
                    }
                }

            }
        }
        System.out.printf("\n");
    }

    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%10d", mMatrix[i][j]);
            System.out.printf("\n");
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
        for (int i = 1; i < index; i++) {
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

    public void floyd(int[][] path, int[][] dist) {
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++) {
                dist[i][j] = mMatrix[i][j];
                path[i][j] = j;
            }
        }
        // 计算最短路径
        for (int k = 0; k < mVexs.length; k++) {
            for (int i = 0; i < mVexs.length; i++) {
                for (int j = 0; j < mVexs.length; j++) {

                    int tmp = (dist[i][k] == INF || dist[k][j] == INF) ? INF : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j] = tmp;
                        // "i到j最短路径"对应的路径，经过k
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

        // 打印floyd最短路径的结果
        System.out.printf("floyd: \n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%2d  ", dist[i][j]);
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E'};
        int matrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*/
          /*A*/ {0, 1, INF, 1, 5},
          /*B*/ {9, 0, 3, 2, INF},
          /*C*/ {INF, INF, 0, 4, INF},
          /*D*/ {INF, INF, 2, 0, 3},
          /*E*/ {3, INF, INF, INF, 0}};
        MatrixUDG pG;

        pG = new MatrixUDG(vexs, matrix);
        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        int[][] path = new int[pG.mVexs.length][pG.mVexs.length];
        int[][] floy = new int[pG.mVexs.length][pG.mVexs.length];
        // floyd算法获取各个顶点之间的最短距离
        pG.floyd(path, floy);
    }

}
