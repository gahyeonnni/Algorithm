import java.io.*; 
import java.util.*; 

class Solution {
    
    private long calculation(long a, long b, String op) {
        switch(op) {
            case "+" : return a + b; 
            case "-": return a - b;
            default : return a * b;
        }
    }
    
    private List<String> getOps(List <String> tokens) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*"))
                set.add(t);
        }
        return new ArrayList<>(set);
    }
        
    private void dfs(List <String> ops, boolean [] used, List <String> order, List <String> tokens, long [] nums) {
        if (order.size() == ops.size()) {
            long v = evalOrder(tokens, order);
            nums[0] = Math.max(Math.abs(v), nums[0]); 
            return;
        }
        
        for (int i = 0; i < ops.size(); i++) {
            if (used[i])
                continue; 
            used[i] = true; 
            order.add(ops.get(i));
            dfs(ops,used,order,tokens,nums);
            order.remove(order.size() - 1);
            used[i] = false;
        }
    }
    
    private long evalOrder(List <String> tokens, List <String> order) {
        List <String> curr = new ArrayList<>(tokens);
        for (String op : order) {
            List <String> next = new ArrayList<>(); 
            next.add(curr.get(0)); 
            for (int i = 1; i < curr.size(); i+= 2) {
                String oper = curr.get(i);
                String right = curr.get(i + 1);
                if (oper.equals(op)) {
                    long leftVal = Long.parseLong(next.remove(next.size() - 1));
                    long rightVal = Long.parseLong(right);
                    long res = calculation(leftVal, rightVal, oper);
                    next.add(String.valueOf(res));
                } 
                else {
                    next.add(oper);
                    next.add(right);
                }
            }
            curr = next;
        }
         return Long.parseLong(curr.get(0));
    }
    
    public long solution(String expression) {
        List<String> tokens = new ArrayList<>(); 
        StringBuilder sb = new StringBuilder(); 
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                tokens.add(sb.toString()); 
                sb.setLength(0);
                tokens.add(String.valueOf(c));
            }
            else 
                sb.append(c);
        }
        tokens.add(sb.toString());
        List <String> ops = getOps(tokens);
        boolean[] used = new boolean[ops.size()];
        List<String> order = new ArrayList<>();
        long[] nums = {0};
        dfs(ops, used, order, tokens, nums);

        return nums[0];
    }
}