import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int n;
    static int[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int [n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][][] dp = new int [n][n][3];
        dp[0][1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1)
                    continue;

                if (j - 1 >= 0) {
                    dp[i][j][0] += dp[i][j-1][0];
                    dp[i][j][0] += dp[i][j - 1][2];
                 }

                if (i - 1 >= 0) {
                    dp[i][j][1] += dp[i-1][j][1];
                    dp[i][j][1] += dp[i-1][j][2];
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (array[i - 1][j] == 0 && array[i][j - 1] == 0) {
                        dp[i][j][2] += dp[i - 1][j - 1][0];
                        dp[i][j][2] += dp[i - 1][j - 1][1];
                        dp[i][j][2] += dp[i - 1][j - 1][2];
                    }
                }
             }
        }
        int answer = dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2];
        System.out.println(answer);
    }
}
