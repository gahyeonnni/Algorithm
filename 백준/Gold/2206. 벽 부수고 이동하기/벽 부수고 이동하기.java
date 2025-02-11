import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int BFS(int [][] square, int x, int y){
        boolean [][][] check = new boolean [x][y][2];
        Queue <int []> queue = new LinkedList<>();
        queue.add(new int [] {0,0,1,1});
        check[0][0][1] = true;


        while (!queue.isEmpty()){
            int xo [] = queue.poll();
            int nx = xo[0];
            int ny  = xo[1];
            int dist = xo[2];
            int chance = xo[3];

            if (nx == x - 1 && ny == y -1 )
                return dist;

            for (int i = 0; i < 4; i++){
                int jx = nx + dx[i];
                int jy = ny + dy[i];
                if (jx >= 0 && jy >= 0 && jx < x && jy < y){
                    if (square[jx][jy] == 0 && !check[jx][jy][chance]){
                        queue.add(new int [] {jx,jy,dist + 1, chance});
                        check[jx][jy][chance] = true;
                    }
                    if (square[jx][jy] == 1 && chance == 1 && !check[jx][jy][0]){
                        queue.add(new int [] {jx,jy, dist + 1, 0});
                        check[jx][jy][0] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sq = br.readLine().split(" ");
        int x = Integer.parseInt(sq[0]);
        int y = Integer.parseInt(sq[1]);
        int[][] square = new int[x][y];

        for (int i = 0; i < x; i++){
            String qo = br.readLine();
            for (int j = 0; j < y; j++){
                square[i][j] = qo.charAt(j) - '0';
            }
        }

        System.out.println(BFS(square, x, y));
    }
}
