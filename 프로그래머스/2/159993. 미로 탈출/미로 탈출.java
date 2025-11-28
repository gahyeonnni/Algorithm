import java.io.*; 
import java.util.*; 

class Solution {
    static int dx [] = {-1, 1, 0, 0}; 
    static int [] dy = {0,0,-1,1};
    
    static int bfs(String[][] array, int startx, int starty, int finishx, int finishy)  {
        boolean[][] check = new boolean[array.length][array[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startx, starty, 0});
        check[startx][starty] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == finishx && y == finishy) 
                return dist;

            for (int i = 0; i < 4; i++) {
                int sx = x + dx[i]; 
                int sy = y + dy[i]; 
                if (sx >= 0 && sy >= 0 && sx < array.length && sy < array[0].length) {
                    if (!check[sx][sy] && !array[sx][sy].equals("X")) {
                        check[sx][sy] = true; 
                        queue.add(new int[]{sx, sy, dist + 1});
                        
                    }
                }
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        int answer = 0;
        String [][] array = new String [maps.length][maps[0].length()];
        int sx = 0; 
        int sy = 0; 
        int lx = 0; 
        int ly = 0; 
        int ex = 0; 
        int ey = 0;
        for (int j = 0; j < maps.length; j++) {
            String map = maps[j];
            for (int i = 0; i < map.length(); i++) {
                String x = map.substring(i, i + 1);
                array[j][i] = x; 
                if (x.equals("S")) {
                    sx = j; 
                    sy = i;
                }
                else if (x.equals("L")) {
                    lx = j; 
                    ly = i; 
                }
                else if (x.equals("E")) {
                    ex = j; 
                    ey = i;
                }
            }
        }
        int dist1 = bfs(array, sx, sy, lx, ly);
        if (dist1 == -1) 
            return -1;
        
        int dist2 = bfs(array, lx, ly, ex, ey);
        if (dist2 == -1) 
            return -1; 

        return dist1 + dist2;
    }
}