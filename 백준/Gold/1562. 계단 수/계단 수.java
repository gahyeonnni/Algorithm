import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][][] dp = new int [n+1][10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    if (dp[i-1][j][k] == 0)
                        continue;

                    if (j < 9) {
                        int mask = k | (1 << (j + 1));
                        dp[i][j+1][mask] += dp[i-1][j][k];
                        dp[i][j+1][mask] %= MOD;
                    }
                    if (j > 0) {
                        int mask = k | (1 << (j - 1));
                        dp[i][j-1][mask] += dp[i-1][j][k];
                        dp[i][j-1][mask] %= MOD;
                    }
                }
            }
        }

        int x = (1 << 10) - 1;
        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans = (ans + dp[n][i][x]) % MOD;
        }
        System.out.println(ans);
    }
}

