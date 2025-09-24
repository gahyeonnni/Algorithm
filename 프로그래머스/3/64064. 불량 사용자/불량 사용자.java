import java.io.*; 
import java.util.*; 

class Solution {
    Set<Set<String>> answer = new HashSet<>();
    
    static boolean check(String a, String b) {
        if (a.length() != b.length())
            return false; 
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '*')
                continue; 
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }
    
    void dfs(int index, String [] banned, List<List<String>> a,  Set<String> ans) {
        if (index == banned.length) {
            answer.add(new HashSet<>(ans)); 
            return;
        }
        
        List <String> x = a.get(index);
        for (String user : x) {
            if (!ans.contains(user)) {
                ans.add(user); 
                dfs(index + 1, banned, a, ans); 
                ans.remove(user);
            }
        }
    }
    
    public int solution(String[] user, String[] banned) {
        List<List<String>> a = new ArrayList<>(); 
        for (String id : banned) {
            List<String> list = new ArrayList<>();
            for (String u : user) {
                if (check(id, u))
                    list.add(u);
            }
            a.add(list);
        }
        dfs(0, banned, a, new HashSet<>());
        
        return answer.size();
    }
}