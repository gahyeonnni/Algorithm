import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int count = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    home.add(new int[]{i, j});
                else if (map[i][j] == 2)
                    chicken.add(new int[]{i, j});
            }
        }

        boolean[] selected = new boolean[chicken.size()];
        select(0,0,selected);
        System.out.println(count);
    }

    static void select(int a, int b, boolean[] selected) {
        if (b == M) {
            count = Math.min(count, cal(selected));
            return;
        }

        for (int i = a; i < chicken.size(); i++) {
            selected[i] = true;
            select(i + 1, b + 1, selected);
            selected[i] = false;
        }
    }

    static int cal(boolean[] selected) {
        int total = 0;

        for (int[] h : home) {
            int hx = h[0];
            int hy = h[1];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (selected[i]) {
                    int [] c = chicken.get(i);
                    int cx = c[0];
                    int cy = c[1];
                    int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                    min = Math.min(min, dist);
                }
            }
            total += min;
        }
        return total;
    }
}
