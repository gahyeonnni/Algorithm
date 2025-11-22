import java.io.*;
import java.util.*;

public class Solution {
	static int answer; 
	static int [] array; 
	static HashSet <Integer> set;
	static void back(int [] array, int count, int sum, int cur) {
		if (count == 3) {
			set.add(sum); 
			return;
		}
		
		for (int i = cur; i < 7; i++) {
			back(array, count + 1, sum + array[i], i + 1);
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	array = new int [7]; 
        	for (int i = 0; i < 7; i++)
        		array[i] = Integer.parseInt(st.nextToken());
        	set = new HashSet<>(); 
        	set.clear();
        	back(array, 0, 0, 0); 
        	List <Integer> list = new ArrayList<>(); 
        	for (int a : set)
        		list.add(a);
        	Collections.sort(list);
        	int len = list.size();
        	System.out.println("#" + (j + 1) + " " + list.get(len - 5));
        }
    }
}
