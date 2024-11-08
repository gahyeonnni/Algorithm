import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = in.next();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }

            }
        }
        int a = N - 7;
        int b = M - 7;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }
    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (arr[i][j] != TF) {
                    count++;
                }
                TF = (!TF);
            }
            TF = !TF;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}