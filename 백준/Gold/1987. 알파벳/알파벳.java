import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Character [][] map;
    static int[] tx = {-1, 1, 0, 0};
    static int[] ty = {0, 0, -1, 1};
    static boolean[] al = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map  = new Character [N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        al[map[0][0] - 'A'] = true; 
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int d = 0; d < 4; d++) {
            int nx = x + tx[d];
            int ny = y + ty[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                int a = map[nx][ny] - 'A';
                if (!al[a]) {
                    al[a] = true;
                    dfs(nx, ny, count + 1);
                    al[a] = false;
                }
            }
        }
    }
}
