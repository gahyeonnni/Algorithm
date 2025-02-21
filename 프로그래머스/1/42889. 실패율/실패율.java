import java.util.*;

class Solution {
    public int [] solution(int N, int[] stages) { 
        int[] answer = new int [N];
        double [][] failevel = new double [N][2];
        
        for (int i = 1; i <= N; i++){
            double a = 0; //스테이지에 도달한 플레이어 수 (각 레벨의 값보다 크거나 같으면 도달한것)
            double b = 0; //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 (레벨과 값이 동일하면 아직 클리어 X)
            double x = 0; //실패율
            
            for (int j : stages){
                if (j >= i)
                    a++;
                if (j == i)
                    b++;
            }
            
            if (a == 0)
                x = 0;
            else
                x = (b / a);
            failevel[i - 1] = new double[] {x, i};
        } 
        
        Arrays.sort(failevel, (a,b) -> {
                    if (a[0] == b[0])
                        return Double.compare(a[1], b[1]);
                    return Double.compare(b[0], a[0]);
        });
        
        for (int i = 0; i < N; i++){
            answer[i] = (int) failevel[i][1];
        }
        return answer;
    }
}