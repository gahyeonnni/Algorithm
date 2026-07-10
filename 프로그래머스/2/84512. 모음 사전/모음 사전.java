import java.io.*; 
import java.util.*; 

class Solution {
    private static String [] moeum = new String [] {"A", "E", "I", "O", "U"};
    private static List <String> list;
    
    private void make(int num, String x) {
        if (num >= 5)
            return;
        for (int i = 0; i < moeum.length; i++) {
            list.add(x + moeum[i]); 
            make(num + 1, x + moeum[i]);
        }
    }
    
    public int solution(String word) {
        list = new LinkedList<>();
        String x = ""; 
        make(0, x); 
        return list.indexOf(word) + 1;
    }
}