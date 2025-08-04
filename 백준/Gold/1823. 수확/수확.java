import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long [][] dp;
    static long answer;
    static int [] cost;
    public static long howmove(int a, int b, int num) {
        if (a > b)
            return 0;
        if (dp[a][b] != -1)
            return dp[a][b];

        int k = num + 1;
        long left = (long) cost[a] * k + howmove(a + 1, b, num + 1);
        long right = (long) cost[b] * k + howmove(a, b - 1, num + 1);

        dp[a][b] = Math.max(left, right);
        return dp[a][b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        cost = new int [n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        dp = new long [n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        answer = howmove(0, n-1, 0);
        System.out.println(answer);
    }
}
