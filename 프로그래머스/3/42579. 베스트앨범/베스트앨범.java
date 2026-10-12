import java.io.*; 
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        List <Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i]; 
            int play = plays[i]; 
            
            music.put(genre, music.getOrDefault(genre, new HashMap<>()));
            music.get(genre).put(i, play);
            count.put(genre, count.getOrDefault(genre, 0) + play);
        }
        
       List<String> genreList = new ArrayList<>(count.keySet());
        genreList.sort((a, b) -> count.get(b) - count.get(a));
        
        for (String gen : genreList) {
            HashMap<Integer, Integer> songs = music.get(gen); 
            List<Integer> idxList = new ArrayList<>(songs.keySet());

            idxList.sort((a, b) -> {
                int playA = songs.get(a);
                int playB = songs.get(b);
                if (playB != playA) {
                    return playB - playA;   
                }
                return a - b;              
            });
            
            for (int i = 0; i < Math.min(2, idxList.size()); i++) {
                ans.add(idxList.get(i));
            }
        }
        
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}