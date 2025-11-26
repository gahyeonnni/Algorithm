import java.io.*;
import java.util.*;

public class Main {
    static long [][] dp = new long[31][31];
    static long solve(int w, int h) {
        if (w == 0 && h == 0)
            return 1;
        if (dp[w][h] != 0)
            return dp[w][h];

        long a = 0;

        if (w > 0)
            a += solve(w - 1, h + 1);
        if (h > 0)
            a += solve(w, h - 1);

        dp[w][h] = a;
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0)
                break;
            System.out.println(solve(x, 0));
        }
    }
}
