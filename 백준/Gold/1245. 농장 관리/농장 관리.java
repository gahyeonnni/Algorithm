import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int [][] array;
    static boolean [][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0,  1, -1, 1, -1,0, 1};
    static boolean check;
    static void dfs(int x, int y, int h) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            if (array[nx][ny] > h)
                check = false;
            if (!visited[nx][ny] && array[nx][ny] == h)
                dfs(nx, ny, h);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int [n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int  j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean [n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && array[i][j] > 0) {
                    check = true;
                    dfs(i, j, array[i][j]);
                    if (check)
                        answer++;
                }
            }
        }
        System.out.println(answer);
    }
}