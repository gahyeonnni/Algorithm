import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static int count;

    static void press(String[][] array, int x, int y) {
        for (int d = 0; d < 5; d++) {
            int ux = x + dx[d];
            int uy = y + dy[d];

            if (ux < 0 || uy < 0 || ux >= 3 || uy >= 3)
                continue;
            array[ux][uy] = array[ux][uy].equals("*") ? "." : "*";
        }
    }

    static boolean isClear(String[][] array) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (array[i][j].equals("*"))
                    return false;
        return true;
    }

    static String[][] copy(String[][] box) {
        String[][] array = new String[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                array[i][j] = box[i][j];
        return array;
    }

    static void dfs(int idx, int cnt, String[][] array) {
        if (idx == 9) {
            if (isClear(array))
                count = Math.min(count, cnt);
            return;
        }

        int x = idx / 3;
        int y = idx % 3;

        dfs(idx + 1, cnt, array);

        String[][] next = copy(array);
        press(next, x, y);
        dfs(idx + 1, cnt + 1, next);
    }

    static int bfs(String[][] box) {
        count = Integer.MAX_VALUE;
        dfs(0, 0, box);
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[][] box = new String[3][3];

            for (int r = 0; r < 3; r++) {
                String a = br.readLine();
                for (int c = 0; c < 3; c++) {
                    box[r][c] = a.substring(c, c + 1);
                }
            }
            System.out.println(bfs(box));
        }
    }
}
