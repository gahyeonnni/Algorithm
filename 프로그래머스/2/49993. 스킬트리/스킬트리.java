import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            String extra = ""; 
            
            for (char c : skill_tree.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    extra += c;
                }
            }
            
            if (skill.startsWith(extra)) {
                answer++;
            }
        }

        return answer;
    }
}
