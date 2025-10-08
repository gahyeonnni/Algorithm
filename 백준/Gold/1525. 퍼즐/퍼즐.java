import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static int [][] array;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0,0,-1,1};
    static int answer = -1;

    static boolean check(int[][] array) {
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) {
                    if (array[i][j] != 0)
                        return false;
                }
                else {
                    if (array[i][j] != num++)
                        return false;
                }
            }
        }
        return true;
    }

    static int[][] copy(int[][] arr) {
        int[][] newArr = new int[3][3];
        for (int i = 0; i < 3; i++)
            newArr[i] = arr[i].clone();
        return newArr;
    }

    static String toString(int [][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int [] row : arr) {
            for (int a : row) {
                sb.append(a);
            }
        }
        return sb.toString();
    }


    static int bfs(int [][] array, int x, int y) {
        Queue<int[][]> queue = new LinkedList<>();
        Queue<int[]> zero = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(copy(array));
        zero.add(new int[]{x, y});
        visited.add(toString(array));

        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int [][] cur = queue.poll();
                int [] z = zero.poll();
                int sx = z[0];
                int sy = z[1];

                if (check(cur))
                    return ans;

                for (int i = 0; i < 4; i++) {
                    int nx = sx + dx[i];
                    int ny = sy + dy[i];
                    if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3)
                        continue;

                    int [][] next = copy(cur);
                    next[sx][sy] = next[nx][ny];
                    next[nx][ny] = 0;

                    String key = toString(next);
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.add(next);
                        zero.add(new int [] {nx, ny});
                    }

                }
            }
            ans++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = new int[3][3];
        int a = 0, b = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] == 0) {
                    a = i;
                    b = j;
                }
            }
        }
        answer = bfs(array, a, b);
        System.out.println(answer);
    }
}

