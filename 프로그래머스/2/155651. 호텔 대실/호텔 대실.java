import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        PriorityQueue <Integer> queue = new PriorityQueue<>(); 
        for (String [] x : book_time) {
            int a1 = Integer.parseInt(x[0].substring(0, 2));
            int a2 = Integer.parseInt(x[0].substring(3));
            int start = a1 * 60 + a2;
            int b1 = Integer.parseInt(x[1].substring(0, 2));
            int b2 = Integer.parseInt(x[1].substring(3));
            int finish = b1 * 60 + b2 + 10;
            while (!queue.isEmpty() && queue.peek() <= start) 
                    queue.poll(); 
            queue.add(finish);
            answer = Math.max(queue.size(), answer);
        }
        return answer;
    }
}