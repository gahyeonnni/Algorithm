import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static int[] num2;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());  
        int b = Integer.parseInt(st.nextToken()); 
        num = new int[a];
        num2 = new int[b]; 
        for (int i = 0; i < a; i++) {
            num[i] = i + 1;
        }
        dfs(0, 0, a, b);
        System.out.println(sb.toString());
    }
    
    private static void dfs(int x, int y, int k, int m) {
        if (y == m) { 
            for (int i = 0; i < m; i++) {
                sb.append(num2[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for (int i = x; i < k; i++) {
            num2[y] = num[i];  
            dfs(i + 1, y + 1, k, m);  
        }
    }
}