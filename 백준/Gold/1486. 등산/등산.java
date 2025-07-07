import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int n, m, t, d;
    static int[][] trees;

    static class Node implements Comparable<Node> {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static int[][] dijkstra(int startX, int startY) {
        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[startX][startY] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startX, startY, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.time > dist[cur.x][cur.y])
                continue;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                int h = trees[nx][ny] - trees[cur.x][cur.y];
                int cost;

                if (Math.abs(h) > t)
                    continue;

                if (h > 0)
                    cost = h * h;
                else
                    cost = 1;

                int newtime = cur.time + cost;

                if (newtime <= d && newtime < dist[nx][ny]) {
                    dist[nx][ny] = newtime;
                    pq.offer(new Node(nx,ny, newtime));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        trees = new int[n][m];
        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < m; j++) {
                char a = x.charAt(j);
                int val;
                if (a >= 'A' && a <= 'Z') val = a - 'A';
                else val = a - 'a' + 26;
                trees[i][j] = val;
            }
        }

        int[][] go = dijkstra(0, 0);

        int answer = trees[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (go[i][j] == Integer.MAX_VALUE)
                    continue;

                int[][] back = dijkstra(i, j);

                if (back[0][0] != Integer.MAX_VALUE && go[i][j] + back[0][0] <= d) {
                        answer = Math.max(answer, trees[i][j]);
                }
            }
        }


        System.out.println(answer);
    }
}
