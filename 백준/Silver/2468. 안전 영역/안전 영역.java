import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 1;

    static void bfs(int[][] newArr, boolean[][] visited, int a, int b, int t) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < t && ny < t) {
                    if (!visited[nx][ny] && newArr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        array = new int[t][t];

        int maxH = 0;

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < t; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, array[i][j]);
            }
        }

        for (int h = 0; h <= maxH; h++) {
            int[][] newArr = new int[t][t];

            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    if (array[i][j] > h)
                        newArr[i][j] = 1;
                    else
                        newArr[i][j] = 0;
                }
            }

            boolean[][] visited = new boolean[t][t];
            int cnt = 0;

            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    if (newArr[i][j] == 1 && !visited[i][j]) {
                        bfs(newArr, visited, i, j, t);
                        cnt++;
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
