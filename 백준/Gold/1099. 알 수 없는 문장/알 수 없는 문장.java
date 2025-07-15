import java.util.*;
import java.io.*;

public class Main {
    static int answer = -1;
    static int n;
    static String allString;
    static String[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        allString = br.readLine();
        n = Integer.parseInt(br.readLine());
        s = new String [n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        int slen = allString.length();
        final int INF = Integer.MAX_VALUE / 2;

        int[][] wordCount = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : s[i].toCharArray()) {
                wordCount[i][c - 'a']++;
            }
        }

        int[] dp = new int[slen + 1];
        Arrays.fill(dp, INF);
        dp[slen] = 0;

        for (int i = slen - 1; i >= 0; i--) {
            for (int k = 0; k < n; k++) {
                int L = s[k].length();
                if (i + L > slen)
                    continue;

                int[] cnt = new int[26];
                for (int j = 0; j < L; j++) {
                    cnt[allString.charAt(i + j) - 'a']++;
                }

                if (!Arrays.equals(cnt, wordCount[k]))
                    continue;

                int cost = 0;
                for (int j = 0; j < L; j++) {
                    if (allString.charAt(i + j) != s[k].charAt(j)) {
                        cost++;
                    }
                }
                dp[i] = Math.min(dp[i], dp[i + L] + cost);
            }
        }
        answer = dp[0] >= INF ? -1 : dp[0];
        System.out.println(answer);
    }
}
