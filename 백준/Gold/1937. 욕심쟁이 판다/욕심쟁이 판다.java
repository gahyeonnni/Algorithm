import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int dx [] = {-1,1,0,0};
    static int dy [] = {0,0, -1, 1};
    public static int DFS(int [][] array, int [][] dp, int x, int y) {
        if (dp[x][y] != 0)
            return dp[x][y];

        dp[x][y] = 1;

        for (int t = 0; t < 4; t++) {
            int nx = x + dx[t];
            int ny = y + dy[t];

            if (nx >= 0 && ny >= 0 && nx < array.length && ny < array.length) {
                if (array[x][y] < array[nx][ny]) {
                    dp[x][y] = Math.max(dp[x][y], DFS(array, dp, nx, ny) + 1);
                }
            }
        }

        return dp[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] array = new int [n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] dp = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, DFS(array, dp, i, j));
            }
        }
        System.out.println(answer);
    }
}
