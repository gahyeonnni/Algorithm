import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int [id_list.length];
        HashMap <String, Integer> hashmap = new HashMap<>(); //신고 몇번 당했는지
        HashMap <String, HashSet<String>> hashwho = new HashMap<>(); //같은사람이 신고한거 없는지 확인
        for (int i = 0; i < report.length; i++){
            String [] x = report[i].split(" ");
            String a = x[0]; //신고한사람
            String b = x[1]; //신고당한사람
            
            //a 가 처음 등장하는 유저라면 밑에서 hashwho.get(a).add(b)를 할때 
            //null 이라 오류 날수있어 HashSet 생성해서 넣어주기
            hashwho.computeIfAbsent(a, key -> new HashSet<>());
            
            if (!hashwho.get(a).contains(b)) {
                hashwho.get(a).add(b);
                hashmap.put(b, hashmap.getOrDefault(b, 0) + 1);
            }   
        }
        
        HashSet <String> finalpeo = new HashSet<>();
        
        for (String x : hashmap.keySet()){
            if (hashmap.get(x) >= k)
                finalpeo.add(x);
        }
        
        for (int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            int count = 0;
            
            if (hashwho.containsKey(user)){
                for (String x :hashwho.get(user)){
                    if (finalpeo.contains(x))
                        count++;
                }
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
}