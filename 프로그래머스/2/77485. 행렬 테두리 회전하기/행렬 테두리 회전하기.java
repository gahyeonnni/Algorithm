import java.io.*; 
import java.util.*; 

class Solution {
    static int [][] origin;
    static int x1, y1, x2, y2;
    
    static void makeFirstArray() {
        int index = 1; 
        int row = origin.length; 
        int col = origin[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                origin[i][j] = index++; 
            }
        }
    }
    
    static int changeArray() {
        int minNumber = Integer.MAX_VALUE; 
        int cur = origin[x1][y1]; 
        
        minNumber = Math.min(minNumber, cur);
        
        for (int i = y1 + 1; i <= y2; i++) {
            int num = origin[x1][i];
            origin[x1][i] = cur; 
            cur = num; 
            minNumber = Math.min(minNumber, num);
        } 
        
        for (int i = x1 + 1; i <= x2; i++) {
            int num = origin[i][y2];
            origin[i][y2] = cur; 
            cur = num; 
            minNumber = Math.min(minNumber, num);
        }
        
        for (int i = y2 - 1; i >= y1; i--) {
            int num = origin[x2][i];
            origin[x2][i] = cur; 
            cur = num; 
            minNumber = Math.min(minNumber, num);
        } 
        
        for (int i = x2 - 1; i >= x1; i--) {
            int num = origin[i][y1];
            origin[i][y1] = cur; 
            cur = num; 
            minNumber = Math.min(minNumber, num);
        }
        
        return minNumber;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int [queries.length]; 
        origin = new int [rows][columns];
        makeFirstArray(); //맨 처음 행렬 생성 
        
        int index = 0;
        for (int [] query : queries) {
            x1 = query[0] - 1; 
            y1 = query[1] - 1; 
            x2 = query[2] - 1; 
            y2 = query[3] - 1;
            
            int minNum = changeArray(); 
            answer[index++] = minNum;
        }
        
        return answer;
    }
}