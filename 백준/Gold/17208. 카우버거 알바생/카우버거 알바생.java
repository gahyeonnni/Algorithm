import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] burger = new int[n + 1];
        int[] fries = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            burger[i] = Integer.parseInt(st.nextToken());
            fries[i] = Integer.parseInt(st.nextToken());
        }

        int [][][] dp = new int [n+1][m+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int p = 0; p <= k; p++) {
                    dp[i][j][p] = dp[i - 1][j][p];
                    if (j >= burger[i] && p >= fries[i]) {
                        dp[i][j][p] = Math.max(dp[i][j][p],
                                dp[i - 1][j - burger[i]][p - fries[i]] + 1);
                    }
                }
            }
        }
        System.out.println(dp[n][m][k]);
    }
}
