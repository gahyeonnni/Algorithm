import java.io.*;
import java.util.*;

public class Main {
    private static int answer = 0;
    private static int [] dx = {-1,1,0,0};
    private static int [] dy = {0,0,1,-1};
    private static Queue<int[]> queue = new LinkedList<>();

    public static void BFS(int[][] arr, int x, int y){
        int [][] visited = new int [arr.length][arr[0].length];
        for (int[] row : visited) {
            Arrays.fill(row, 0);
        }
        visited[x][y] = 1;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()){
            int [] current = queue.poll();
            int nx = current[0];
            int ny = current[1];

            for (int i = 0; i < 4; i++){
                int bx = nx + dx[i];
                int by = ny + dy[i];

                if (bx >= 0 && bx < arr.length && by >= 0 && by < arr[0].length && arr[bx][by] == 1 &&  visited[bx][by] == 0 ){
                    visited[bx][by] = visited[nx][ny] + 1;
                    queue.add(new int[]{bx, by});
                }
            }

            if (visited[arr.length - 1][arr[0].length - 1] != 0) {
                answer = visited[arr.length - 1][arr[0].length - 1];
                return;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);

        int[][] arr = new int[a][b];

        for (int i = 0; i < a; i++) {
            String input = br.readLine();
            for (int j = 0; j < b; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        BFS(arr, 0, 0);
        System.out.println(answer);
    }
}