import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] num = new int[w];
		
		for(int i = 0; i < w; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		LinkedList<Integer> stack = new LinkedList<>();
        int current = 1; 
        boolean a = true;
        
        for (int i = 0; i < w; i++) {
            int target = num[i];
            
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }
            
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } 
            else {
                a = false;
                break;
            }
        }
        
        if (a) {
            System.out.print(sb);
        } 
        
        else {
            System.out.println("NO");
        }
	}
}