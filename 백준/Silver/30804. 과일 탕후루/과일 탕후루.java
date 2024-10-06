import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  
        int[]num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer,Integer> fruit = new HashMap<>();
        int maxLength = 0; 
        int left = 0;
        for(int right = 0; right < N; right++) {
        	fruit.put(num[right],fruit.getOrDefault(num[right], 0) + 1);
        	while (fruit.size() > 2) {
        		fruit.put(num[left], fruit.get(num[left]) - 1);
        		if (fruit.get(num[left]) == 0) {
        			fruit.remove(num[left]);
        		}
        		left++;
        	}
        	maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }
}