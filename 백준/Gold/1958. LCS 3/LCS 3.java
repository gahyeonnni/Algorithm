import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;

    public static int lcs3(String a, String b, String c) {
        int[][][] dp = new int[a.length() + 1][b.length() + 1][c.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                for (int k = 1; k <= c.length(); k++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(
                                Math.max(dp[i - 1][j][k], dp[i][j - 1][k]),
                                dp[i][j][k - 1]
                        );
                    }
                }
            }
        }

        return dp[a.length()][b.length()][c.length()];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(bf.readLine());
        String a = bf.readLine();
        String b = bf.readLine();
        String c = bf.readLine();

        answer = lcs3(a,b,c);
        System.out.println(answer);
    }
}
