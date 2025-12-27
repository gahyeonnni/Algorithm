import java.io.*; 
import java.util.*; 

class Solution {
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static int rx, ry;
    static int gx, gy;
    static char[][] box;
    static int n, m;
    static int bfs() {
    Queue <int[]> q = new LinkedList<>();
    boolean [][] visited = new boolean[n][m];

    q.add(new int[]{rx, ry, 0}); 
    visited[rx][ry] = true;

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int x = cur[0];
        int y = cur[1];
        int cnt = cur[2];

        if (x == gx && y == gy) {
            return cnt;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;

            while (true) {
                int tx = nx + mx[d];
                int ty = ny + my[d];

                if (tx < 0 || ty < 0 || tx >= n || ty >= m)
                    break;
                
                if (box[tx][ty] == 'D')
                    break;
                
                nx = tx;
                ny = ty;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, cnt + 1});
            }
        }
    }
    return -1;
}

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        box = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                box[i][j] = c;
                if (c == 'R') {
                    rx = i;
                    ry = j;
                } 
                else if (c == 'G') {
                    gx = i;
                    gy = j;
                }
            }
        }
        return bfs();
    }
}