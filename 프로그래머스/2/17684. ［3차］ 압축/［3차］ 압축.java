import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = new int [msg.length()];
        LinkedHashMap <String , Integer> hashmap = new LinkedHashMap<>();
        
        int dindex = 1;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            hashmap.put(String.valueOf(ch), dindex++);
        }
        
        //msg 위치 
        int i = 0;
        //answer 값 넣을 위치 
        int index = 0;
        
        while (i < msg.length()){
            String check = "" + msg.charAt(i);
            int j = i + 1;
            
            while (j <= msg.length() && hashmap.containsKey(check)){
                if (j == msg.length()) 
                    break;
                check += msg.charAt(j);
                j++;
            }
            
            if (!hashmap.containsKey(check)){
                check = check.substring(0, check.length() - 1);
                j--;
            }
            
            answer[index++] = hashmap.get(check);
            
            if (j < msg.length()){
                String qp = check + msg.charAt(j);
                hashmap.put(qp, dindex++);
            }
            
            i = j;
        }
        
        return Arrays.copyOf(answer, index);
    }
}