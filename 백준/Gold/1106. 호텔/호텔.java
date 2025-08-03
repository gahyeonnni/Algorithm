import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List <int[]> cost = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int procost = Integer.parseInt(st.nextToken());
            int propeople = Integer.parseInt(st.nextToken());
            cost.add(new int [] {procost, propeople});
        }
        int [] dp = new int [1101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int answer = Integer.MAX_VALUE;
        for (int [] a : cost) {
            int co = a[0];
            int pe = a[1];

            for (int j = pe; j < 1101; j++) {
                if (dp[j - pe] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - pe] + co);
            }
        }
        for (int i = c; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
