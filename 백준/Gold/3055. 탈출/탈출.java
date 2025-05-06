import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int wx, wy; //물 위치
    static int px, py; //고슴도치 위치 저장
    static int destx, desty; //비버 위치
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] watermove;
    static int[][] petmove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (line.charAt(j) == '*') {
                    wx = i;
                    wy = j;
                } else if (line.charAt(j) == 'S') {
                    px = i;
                    py = j;
                } else if (line.charAt(j) == 'D') {
                    destx = i;
                    desty = j;
                }
            }
        }
        water(map);
        petM(map, px, py);
    }

    static void water(char[][] map) {
        watermove = new int[R][C];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] qx = queue.poll();
            int sx = qx[0];
            int sy = qx[1];
            for (int i = 0; i < 4; i++) {
                int ox = sx + dx[i];
                int oy = sy + dy[i];
                if (ox >= 0 && oy >= 0 && ox < R && oy < C) {
                    if (!visited[ox][oy] && map[ox][oy] == '.') {
                        watermove[ox][oy] = watermove[sx][sy] + 1;
                        visited[ox][oy] = true;
                        queue.add(new int[]{ox, oy});
                    }
                }
            }
        }
    }

    static void petM(char[][] map, int x, int y) {
        petmove = new int[R][C];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] qx = queue.poll();
            int sx = qx[0];
            int sy = qx[1];

            for (int i = 0; i < 4; i++) {
                int ox = sx + dx[i];
                int oy = sy + dy[i];

                if (ox >= 0 && oy >= 0 && ox < R && oy < C) {
                    if (visited[ox][oy])
                        continue;
                    if (map[ox][oy] == 'X')
                        continue;

                    if (map[ox][oy] == 'D') {
                        petmove[ox][oy] = petmove[sx][sy] + 1;
                        System.out.println(petmove[ox][oy]);
                        return;
                    }

                    if (map[ox][oy] == '.') {
                        if (watermove[ox][oy] == 0 || petmove[sx][sy] + 1 < watermove[ox][oy]) {
                            petmove[ox][oy] = petmove[sx][sy] + 1;
                            visited[ox][oy] = true;
                            queue.add(new int[]{ox, oy});
                        }
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
}
