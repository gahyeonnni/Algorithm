import java.io.*;   
import java.util.*; 

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);  // 기본 값은 -1로 설정
        
        Stack<Integer> stack = new Stack<>();
        
        // 배열을 뒤에서부터 순회
        for (int i = 0; i < numbers.length; i++) {
            // stack이 비지 않고, 현재 값이 stack의 top 값보다 크면 answer에 값을 설정
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i); // 현재 인덱스를 stack에 넣음
        }
        
        return answer;
    }
}
