import java.io.*; 
import java.util.*; 

class Solution { 
    static boolean isCorrect(String u) {
        int openCount = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                openCount++; 
            } else {
                openCount--;
            }
            if (openCount < 0) {
                return false;
            }
        }
        return openCount == 0;
}
    
    static List<String> makeUVString(String p) {
        List<String> list = new ArrayList<>();
        int leftCount = 0; 
        int rightCount = 0; 
        int splitIndex = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
                splitIndex = i + 1; 
                break;            
            }
        }
        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);
        
        list.add(u); 
        list.add(v);
        return list;
    }
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }
        List<String> uv = makeUVString(p); 
        String u = uv.get(0); 
        String v = uv.get(1); 
        if (isCorrect(u)) {
            return u + solution(v); 
        } 
        else {
            String answer = "(" + solution(v) + ")";
            u = u.substring(1, u.length() - 1);
            String reversedU = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    reversedU += ")";
                } else {
                    reversedU += "(";
                }
            }
            answer += reversedU;
            return answer;
        }
    }
}