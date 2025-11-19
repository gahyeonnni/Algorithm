import java.io.*;
import java.util.*;

public class Solution {   
	static List <Integer> list;  
	static void backTracking(int sum, int i, int calsum, int [] cal, int [] score, int max, boolean [] check) {
		if (calsum > max) {
			return;
		}
		list.add(sum); 
		for (int j = i; j < cal.length; j++) {
			if (!check[j]) {
				check[j] = true; 
				backTracking(sum + score[j], j + 1, calsum + cal[j], cal, score, max, check); 
				check[j] = false;
			}
		}
	}
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //testCase 개수
        int index = 1; 
        for (int i = 0; i < t; i++) { 
        	list = new ArrayList<>();  
        	StringTokenizer st = new StringTokenizer(br.readLine()); 
        	int n = Integer.parseInt(st.nextToken()); 
        	int max = Integer.parseInt(st.nextToken()); 
        	int [] cal = new int [n]; 
        	int [] score = new int [n];
        	boolean [] check = new boolean [n];
        	for (int j = 0; j < n; j++) {
        		st = new StringTokenizer(br.readLine()); 
            	int a = Integer.parseInt(st.nextToken()); 
            	int b = Integer.parseInt(st.nextToken());  
            	score[j] = a; 
            	cal[j] = b;
        	}
        	backTracking(0, 0, 0, cal, score, max, check);
        	Collections.sort(list); 
        	System.out.println("#" + index + " " + list.get(list.size() - 1)); 
        	index++;
        }
    }
}
