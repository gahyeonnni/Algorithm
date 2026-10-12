import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> allClothes = new HashMap<>(); 
        for (String [] clothe : clothes) {
            allClothes.put(clothe[1], allClothes.getOrDefault(clothe[1], 0) + 1);
        }
        for (String key : allClothes.keySet()) {
            answer *= allClothes.get(key) + 1;
        }
        return answer - 1;
    }
}