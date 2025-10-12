import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static StringTokenizer st;
    static List <Integer> list;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int t = 0; t < n; t++) {
            boolean [][] dp = new boolean [501][50001];
            dp[0][0] =  true;

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            list.clear();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= 500; i++) {
                if (i > m)
                    break;
                for (int j = i; j <= m; j++) {
                    int a = j - i;
                    for (int x : list) {
                        int b = i - x;
                        if (b >= 0 && dp[b][a]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
            answer = -1;
            for (int i = 500; i >= 1; i--) {
                if (dp[i][m]) {
                    answer = i;
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}