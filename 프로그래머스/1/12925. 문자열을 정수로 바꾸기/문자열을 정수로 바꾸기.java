class Solution {
    public int solution(String s) {
        int answer = 0;
        int sign = 1; 
        for (Character c : s.toCharArray()){
            if (c == '+' || c == '-'){
                if (c == '-')
                    sign = sign * -1;
                continue;
            }
            else {
                answer = answer * 10 + c  - '0';
            }
        }
        return answer * sign;
    }
}