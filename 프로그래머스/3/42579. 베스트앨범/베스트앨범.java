import java.util.*;

class Solution {
    private static int [] answer;
    public int [] solution(String[] genres, int[] plays) {
        HashMap <String, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++){
            String a = genres[i];
            int b = plays[i];
            
            hash.put(a, hash.getOrDefault(a, 0) + b);
        }
        
        String [][] dict = new String [hash.size()][2];
        int index = 0;
        for (String k : hash.keySet()){
            dict[index][0] = k;
            dict[index][1] = String.valueOf(hash.get(k));
            index++;
        }
        
        Arrays.sort(dict, (a, b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])));
        
        Queue <Integer> finallist = new LinkedList<>();
        
        for (int i = 0; i < dict.length; i++) {
            String song = dict[i][0];
            List <int []> queue = new LinkedList<>();
            for (int j = 0; j < genres.length; j++){
                if (genres[j].equals(song)){
                    queue.add(new int [] {plays[j] , j});
                }
            }
            queue.sort((a,b) -> Integer.compare(b[0], a[0]));
            
            if (queue.size() > 0) {
                finallist.add(queue.get(0)[1]);
                if (queue.size() > 1) {
                    finallist.add(queue.get(1)[1]);
                }
            }
        }
        int size = finallist.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = finallist.poll();
        }
        return answer;
    }
}