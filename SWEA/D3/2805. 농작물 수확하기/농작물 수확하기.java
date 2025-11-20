import java.io.*;
import java.util.*;

public class Solution {  
	static List <String> list;
	static int howmany(List <String> list, int len) {
		int ans = 0;  
		int count = 1;
		int index = 0; 
		int start1 = len / 2; 
		int start2 = 0;
		int total = len;
		while (total-- > 0) {
			String s = list.get(index); //처음부터 하나씩 출력함  
			if (index < len / 2) {
				String k = s.substring(start1, start1 + count); 
				for (int i = 0; i < k.length(); i++)
					ans += k.charAt(i) - '0';
				start1--;
				count += 2; 
				index++;
			}
			else {
				String k = s.substring(start2, start2 + count); 
				for (int i = 0; i < k.length(); i++)
					ans += k.charAt(i) - '0';
				start2++;
				count -= 2; 
				index++;
			}
		}
		return ans;
	}
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < num; i++) {
        	int t = Integer.parseInt(br.readLine()); 
        	list = new ArrayList<>();
        	for (int j =0; j < t; j++) {
        		String s = br.readLine(); 
        		list.add(s);
        	}
        	int ans = howmany(list, t); 
        	System.out.println("#" + (i + 1) + " " + ans);
        }
    }
}
