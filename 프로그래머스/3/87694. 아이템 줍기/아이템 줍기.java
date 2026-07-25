import java.io.*; 
import java.util.*; 

class Solution {
    static int findRoute(int[][] map, int startX, int startY, int targetX, int targetY) {
        int[] dx = {-1, 1, 0, 0}; 
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[102][102];
        
        Queue <int []> queue = new LinkedList<>(); 
        queue.add(new int[]{startX, startY, 0});
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if (x == targetX && y == targetY) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; 
                int ny = y + dy[i]; 
                
                if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100) {
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return 0;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = new int[102][102];
        
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        if (map[y][x] != 2) {
                            map[y][x] = 1;
                        }
                    }
                    else 
                        map[y][x] = 2;
                }
            }
        }
        
        int startX = characterX * 2;
        int startY = characterY * 2;
        int targetX = itemX * 2;
        int targetY = itemY * 2;
        
        return findRoute(map, startX, startY, targetX, targetY) / 2;
    }
}