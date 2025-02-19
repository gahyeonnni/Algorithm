import java.util.*;

class Solution {
    private static int [] dx = {-1,1,0,0};
    private static int [] dy = {0,0, -1,1};
    private static int answer = -1;
    private static boolean [][] visited;
    
    private static void CHECK (int [][] maps, boolean [][] visited, int x, int y){
        Queue <int []> queue = new LinkedList<>();
        queue.add(new int [] {x,y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()){
            int [] xo = queue.poll();
            int a = xo[0];
            int b = xo[1];
            for (int i = 0; i < 4; i++){
                int hx = a + dx[i];
                int hy = b + dy[i];
                if (hx >= 0 && hx < maps.length && hy >= 0 && hy < maps[0].length 
                    && maps[hx][hy] == 1 && !visited[hx][hy]){
                    queue.add(new int [] {hx,hy});
                    visited[hx][hy] = true;
                    maps[hx][hy] = maps[a][b] + 1;
                }
                if (hx == maps.length - 1 && hy == maps[0].length - 1)
                    answer = maps[maps.length - 1][maps[0].length - 1];
            }
        }
        
    }
    
    public int solution(int[][] maps) {
        visited = new boolean [maps.length][maps[0].length];
        CHECK(maps, visited, 0, 0);
        return answer;
    }
}