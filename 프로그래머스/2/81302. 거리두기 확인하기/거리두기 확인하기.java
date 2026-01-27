import java.io.*; 
import java.util.*; 

class Solution {
    static int n;
    
    static int [] x8 = {-1, -1, 1, 1}; 
    static int [] y8 = {-1, 1, -1, 1};
    
    static int [] dx = {-1, 1, 0, 0}; 
    static int [] dy = {0, 0, -1, 1};
    static List <int[]> personList = new ArrayList<>();
    
    static String [][] makeBox(String [] p) {
        String [][] box = new String [p.length][p[0].length()]; 
        for (int i = 0; i < p.length; i++) {
            String x = p[i]; 
            for (int j = 0; j < x.length(); j++) {
                box[i][j] = "" + x.charAt(j);
                if (x.charAt(j) == 'P') {
                    personList.add(new int [] {i, j});
                }
            }
        }
        return box;
    }
    
    static boolean checkNoPerson(String [][] box) {
        for (int [] person : personList) {
            int a = person[0];
            int b = person[1];  
            
           for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (box[x][y].equals("P")) 
                        return false;
                }
            }

            
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i] * 2;
                int y = b + dy[i] * 2;
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (box[x][y].equals("P")) {
                        int mx = a + dx[i];
                        int my = b + dy[i];
                        if (!box[mx][my].equals("X")) 
                            return false;
                        }
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int x = a + x8[i];
                int y = b + y8[i];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (box[x][y].equals("P")) {
                        if (!box[a][y].equals("X") || !box[x][b].equals("X")) 
                            return false;
                        }
                    }
            } 
        } 
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int [places.length]; 
        
        for (int i = 0; i < places.length; i++) {
            personList.clear(); 
            String [] p = places[i];  
            String [][] box = makeBox(p); 
            n = box.length;
            if (personList.size() == 0)
                answer[i] = 1;
            else 
                answer[i] = checkNoPerson(box) ? 1 : 0;
        }
        return answer;
    }
}