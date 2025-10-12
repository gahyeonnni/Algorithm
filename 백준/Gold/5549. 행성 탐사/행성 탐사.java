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
        k = Integer.parseInt(br.readLine());

        int[][] J = new int[n + 1][m + 1];
        int[][] O = new int[n + 1][m + 1];
        int[][] I = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = s.charAt(j - 1);
                J[i][j] = J[i - 1][j] + J[i][j - 1] - J[i - 1][j - 1] + (c == 'J' ? 1 : 0);
                O[i][j] = O[i - 1][j] + O[i][j - 1] - O[i - 1][j - 1] + (c == 'O' ? 1 : 0);
                I[i][j] = I[i - 1][j] + I[i][j - 1] - I[i - 1][j - 1] + (c == 'I' ? 1 : 0);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int jCount = J[c][d] - J[a - 1][d] - J[c][b - 1] + J[a - 1][b - 1];
            int oCount = O[c][d] - O[a - 1][d] - O[c][b - 1] + O[a - 1][b - 1];
            int iCount = I[c][d] - I[a - 1][d] - I[c][b - 1] + I[a - 1][b - 1];

            sb.append(jCount).append(" ").append(oCount).append(" ").append(iCount).append("\n");
        }
        System.out.print(sb);
    }
}