import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[][] weightTrash, weightNear;
    static int[][] bestTrash, bestNear;
    static boolean[][] visited;
    static int ansTrash = Integer.MAX_VALUE;
    static int ansNear = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x,y,trash,near;
        Node(int x, int y, int t, int n) {
            this.x = x;
            this.y = y;
            this.trash = t;
            this.near = n;
        }
        public int compareTo(Node o) {
            if (this.trash != o.trash)
                return this.trash - o.trash;
            return this.near - o.near;
        }
    }
    static void start(int sx, int sy) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(sx, sy, 0, 0));

        bestTrash[sx][sy] = 0;
        bestNear[sx][sy] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;

            if (map[x][y] == 'F') {
                ansTrash = cur.trash;
                ansNear = cur.near;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;


                int nt = cur.trash + weightTrash[nx][ny];
                int nn = cur.near  + weightNear[nx][ny];

                if (nt < bestTrash[nx][ny] || (nt == bestTrash[nx][ny] && nn < bestNear[nx][ny])) {
                    bestTrash[nx][ny] = nt;
                    bestNear[nx][ny] = nn;
                    pq.add(new Node(nx, ny, nt, nn));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int startX = 0, startY = 0, goalX = 0, goalY = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 'F') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        weightTrash = new int[n][m];
        weightNear  = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                weightTrash[i][j] = (map[i][j] == 'g') ? 1 : 0;
                if (map[i][j] != 'g') {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m
                                && map[ni][nj] == 'g') {
                            weightNear[i][j] = 1;
                            break;
                        }
                    }
                }
            }
        }

        weightTrash[startX][startY] = 0;
        weightNear [startX][startY] = 0;
        weightTrash[goalX][goalY]   = 0;
        weightNear [goalX][goalY]   = 0;

        bestTrash = new int[n][m];
        bestNear  = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(bestTrash[i], Integer.MAX_VALUE);
            Arrays.fill(bestNear [i], Integer.MAX_VALUE);
        }

        start(startX, startY);
        System.out.println(ansTrash + " " + ansNear);
    }
}
