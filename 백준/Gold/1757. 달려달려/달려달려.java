import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] meters = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            meters[i] = Integer.parseInt(bf.readLine());
        }

        int[] totalDistance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            totalDistance[i] = totalDistance[i - 1] + meters[i];
        }

        int[] dp = new int[n + 2];

        for (int time = 1; time <= n + 1; time++) {
            dp[time] = Math.max(dp[time], dp[time - 1]);

            for (int runTime = 1; runTime <= m && time + 2 * runTime <= n + 1; runTime++) {
                int runStart = time;
                int runEnd = time + runTime - 1;
                int gain = totalDistance[runEnd] - totalDistance[runStart - 1];
                dp[time + 2 * runTime] = Math.max(dp[time + 2 * runTime], dp[time] + gain);
            }
        }

        System.out.println(dp[n + 1]);
    }
}
