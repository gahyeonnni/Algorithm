import java.util.*;
import java.io.*;

class Solution {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0,0, -1, 1};
    
    static void BFS(int [][] land, boolean [][] check, int x, int y, int num, HashMap<Integer, Integer> map) {
        Queue <int []> queue = new LinkedList<>();
        queue.add(new int [] {x, y});
        check[x][y] = true;
        land[x][y] = num;
        
        int count = 1;
        
        while (!queue.isEmpty()) {
            int [] co = queue.poll();
            int p = co[0];
            int q = co[1]; 
            for (int i = 0; i < 4; i++)
            {
                int cx = p + dx[i];
                int cy = q + dy[i];
                if ( cx >= 0 && cy >= 0 && cx < land.length && cy < land[0].length) {
                    if (!check[cx][cy] && land[cx][cy] != 0){
                        queue.add(new int [] {cx,cy});
                        check[cx][cy] = true;
                        land[cx][cy] = num;
                        count++;
                    }
                } 
            }
        }
        map.put(num, count);
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        boolean [][] check = new boolean [land.length][land[0].length];
        int num = 1;
        HashMap <Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (!check[i][j] && land[i][j] != 0) {
                    BFS(land, check, i, j, num, map);
                    num++; 
                }
            }
        }
        for (int i = 0; i < land[0].length; i++)
        {
            HashSet <Integer> set = new HashSet<>();
            for (int j = 0; j < land.length; j++)
            {
                if (land[j][i] != 0)
                    set.add(land[j][i]);
            }
            int sum = 0;
            for (int p : set)
                sum += map.get(p);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
} 