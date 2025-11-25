import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int [] array = new int [a];
        for (int i = 0; i < a; i++)
            array[i] = Integer.parseInt(br.readLine());
        Arrays.sort(array);
        int [] dp = new int [b + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < a; i++) {
               for (int j = array[i]; j <= b; j++) {
                   if (dp[j - array[i]] != Integer.MAX_VALUE)  {
                       dp[j] = Math.min(dp[j], dp[j - array[i]] + 1);
                   }
               }
        }
        if (dp[b] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[b]);
    }
}
