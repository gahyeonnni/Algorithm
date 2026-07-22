import java.io.*; 
import java.util.*; 

class Solution {
    static List<List<Integer>> list;
    static int answer;
    
    static boolean makeLight(List<List<Integer>> list, int start, boolean [] check) {
        check[start] = true; 
        boolean curLight = false; 
        
        for (int house : list.get(start)) {
            if (!check[house]) {
                boolean childLight = makeLight(list, house, check);
                if (!childLight) {
                    curLight = true;
                }
            }
        }
        
        if (curLight)
            answer++; 
        
        return curLight;
    }
    
    public int solution(int n, int[][] lighthouse) {
        list = new ArrayList<>(); 
        
        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        
        for (int [] light : lighthouse) {
            int a = light[0]; 
            int b = light[1]; 
            list.get(a).add(b); 
            list.get(b).add(a);
        }
        
        makeLight(list, 1, new boolean [n+1]);
        return answer;
    }
}