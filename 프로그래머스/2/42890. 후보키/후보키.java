import java.util.*;

class Solution {
    
    private static Queue<List<Integer>> queue = new LinkedList<>();
    private static List<Set<Integer>> hash = new ArrayList<>();
    
    static void BFS(int count){
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new LinkedList<>());
        
        for (int i = 0; i < count; i++){
            int size = q.size();
            for (int j = 0; j < size; j++){
                List<Integer> subset = new LinkedList<>(q.poll());
                q.add(new LinkedList<>(subset));
                subset.add(i);
                q.add(subset);
            }
        }
        
        q.poll();
        queue.addAll(q);
    }
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        int count = relation[0].length;
        BFS(count);
        
        while (!queue.isEmpty()){
            List<Integer> col = queue.poll();
            if (check(col, relation) && mini(col)){
                hash.add(new HashSet<>(col));
            }
        }
        
        return hash.size();
    }
    
    static boolean check(List<Integer> col, String [][] relation){
        Set<String> uq = new HashSet<>();
        
        for (String [] row : relation){
            StringBuilder key = new StringBuilder();
            for (int colm : col){
                key.append(row[colm]).append(",");
            }
            uq.add(key.toString());
        }
        
        return uq.size() == relation.length;
    }
    
    
    static boolean mini(List <Integer> col){
        Set<Integer> colset = new HashSet<>(col);
        
        for (Set<Integer> s : hash){
            if (colset.containsAll(s)){
                return false;
            }
        }
        
        return true;
    }
}