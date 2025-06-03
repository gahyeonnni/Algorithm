import java.io.*;
import java.util.*;

class Solution {
    List<int[]> moves = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2); 
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        return answer;
    }
    public void hanoi(int n, int a, int b, int c) {
        if (n == 1) {
            moves.add(new int[] {a,b});
            return;
        }
        hanoi(n-1, a, c, b);
        moves.add(new int[]{a, b}); 
        hanoi(n - 1, c, b, a);
    }
}