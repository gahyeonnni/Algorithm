import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0; 
        List <Integer> list = new ArrayList<>();
        list.add(numbers[0]); 
        list.add(-numbers[0]);
        
        for (int i = 1; i < numbers.length; i++) {
            List<Integer> nextList = new ArrayList<>(); 
            for (int num : list) {
                nextList.add(num + numbers[i]);
                nextList.add(num - numbers[i]);
            }
            list = nextList; 
        }
        
        for (int k : list)
            if (k == target)
                answer++;
        return answer;
    }
}