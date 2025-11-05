import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int [][] array;
    static boolean [][] check;
    static int answer = 0;
    static boolean notmove(int a, int b, int [][] array) {
        for (int i = 0; i < a; i++) {
            if (array[i][b] == 1)
                return false;
        }
        for (int i = a - 1, j = b - 1; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == 1)
                return false;
        }
        for (int i = a - 1, j = b + 1; i >= 0 && j < n; i--, j++) {
            if (array[i][j] == 1)
                return false;
        }
        return true;
    }

    static void back(int [][] array, boolean [][] check, int a) {
        if (a == n) {
                answer++;
                return;
        }

        for (int j = 0; j < n; j++) {
            if (!check[a][j] && notmove(a, j, array)) {
                array[a][j] = 1;
                check[a][j] = true;
                back(array, check, a + 1);
                array[a][j] = 0;
                check[a][j] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int [n][n];
        check = new boolean [n][n];
        back(array, check, 0);
        System.out.println(answer);
    }
}
