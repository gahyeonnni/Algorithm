class Solution
{
    static int check(String s, int start, int last) {
        int n = s.length(); 
        
        while (start >= 0 && last < n && s.charAt(start) == s.charAt(last)) {
            start--; 
            last++;
        }
        
        return last - start - 1;
     }
    
    public int solution(String s)
    {
        int answer = 1; 
        int n = s.length(); 
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, check(s, i, i)); 
            if (i + 1 < n)
                answer = Math.max(answer, check(s, i, i + 1));
        }
        return answer;
    }
}