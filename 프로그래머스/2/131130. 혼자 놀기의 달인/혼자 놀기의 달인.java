import java.io.*; 
import java.util.*; 

class Solution {
    static void open(int [] cards, boolean [] check, int a, List <Integer> list) {
        int j = a;
        while (!check[j]) {
            list.add(j);
            int k = cards[j] - 1; 
            check[j] = true;
            j = k; 
        }
    }
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] check = new boolean[n];
        List<Integer> group = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                List<Integer> list = new ArrayList<>();
                open(cards, check, i, list);
                group.add(list.size());
            }
        }

        if (group.size() < 2)
            return 0; 
         
        Collections.sort(group, Collections.reverseOrder()); 
        return group.get(0) * group.get(1);
        
    }
}