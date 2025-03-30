import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] tx = {-1, 1, 0, 0};
    static int[] ty = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(BFS());
    }

    static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] px = queue.poll();
            int a = px[0];
            int b = px[1];
            int broke = px[2];
            int dist = px[3];

            if (a == N - 1 && b == M-1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int dx = a + tx[i];
                int dy = b + ty[i];

                if (dx < 0 || dy< 0 || dx >= N || dy >= M)
                    continue;

                if (map[dx][dy] == 0 && !visited[dx][dy][broke]) {
                    visited[dx][dy][broke] = true;
                    queue.offer(new int [] {dx,dy,broke,dist + 1});
                }

                if (map[dx][dy] == 1 && broke == 0 && !visited[dx][dy][1]) {
                    visited[dx][dy][1] = true;
                    queue.offer(new int [] {dx,dy,1,dist + 1});
                }
            }
        }
        return -1;
    }
}
