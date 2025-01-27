import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap <String, String> username = new HashMap<>();
        ArrayList<String[]> logs = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++){
            String [] command = record[i].split(" ");
            String userId = command[1];
            
            if (command[0].equals("Enter")){
                username.put(userId, command[2]);
                logs.add(new String[]{userId, "님이 들어왔습니다."});
            }
            
            else if (command[0].equals("Leave")){
                logs.add(new String[]{userId, "님이 나갔습니다."});
            }
            
            else if (command[0].equals("Change")){
                username.put(userId, command[2]);
            }
        }
        
        String[] answer = new String [logs.size()];
        
        for (int i = 0; i < logs.size(); i++){
            String[] log = logs.get(i);
            String user = log[0];
            String message = log[1];
            answer[i] = username.get(user) + message;
        }
        
        return answer;
    }
}