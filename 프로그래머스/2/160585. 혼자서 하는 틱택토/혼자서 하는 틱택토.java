import java.io.*; 
import java.util.*; 

class Solution {
    static boolean checkHorizontal (String [][] map, String player) { //가로 체크
        for (int i = 0; i < map.length; i++) {
            if (map[i][0].equals(player) && map[i][1].equals(player) && map[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
    
    static boolean checkvertical (String [][] map, String player) { //세로 체크
        for (int i = 0; i < map.length; i++) {
            if (map[0][i].equals(player) && map[1][i].equals(player) && map[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }
    
    static boolean checkdiagonal (String [][] map, String player) { //대각선 체크
        if (map[0][0].equals(player) && map[1][1].equals(player) && map[2][2].equals(player)) 
            return true;
        if (map[0][2].equals(player) && map[1][1].equals(player) && map[2][0].equals(player)) 
            return true;
        return false;
    } 
    
    public int solution(String[] board) {
        int answer = 1;
        int circle = 0; 
        int nomark = 0;
        String [][] map = new String [3][3];
        
        for (int i = 0; i < board.length; i++) {
            String x = board[i];
            for (int j = 0; j < x.length(); j++) {
                map[i][j] = x.substring(j, j+1);
                if (x.substring(j, j+1).equals("O"))
                    circle++; 
                else if (x.substring(j, j+1).equals("X"))
                    nomark++; 
                else 
                    continue;   
            }
        }
        
        if (circle == 0 && nomark == 0)
            return 1;
        if (circle != nomark) {
            if (circle < nomark)
                return 0;
            else if (circle - nomark > 1)
                return 0;
        }
        
        boolean oWin = checkHorizontal(map,"O") || checkvertical(map,"O") || checkdiagonal(map,"O");
        boolean xWin = checkHorizontal(map,"X") || checkvertical(map,"X") || checkdiagonal(map,"X");
        
        if (oWin && xWin) 
            return 0;
        
        if (oWin && circle != nomark + 1) 
            return 0;
        
        if (xWin && circle != nomark) 
            return 0;
        
        return 1;
    }
}