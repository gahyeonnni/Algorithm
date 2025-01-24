import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 =str2.toLowerCase();
        
        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        
		for(int i = 0; i < str1.length()-1; i++) {
			char a = str1.charAt(i);
			char b = str1.charAt(i+1);

			if(Character.isLetter(a) && Character.isLetter(b)) {
				String str = Character.toString(a) + Character.toString(b);
				list1.add(str);
			}
		}

		for(int i = 0; i < str2.length()-1; i++) {
			char a = str2.charAt(i);
			char b = str2.charAt(i+1);

			if(Character.isLetter(a) && Character.isLetter(b)) {
				list2.add(Character.toString(a) + Character.toString(b));
			}
        }
        
        Collections.sort(list1);
		Collections.sort(list2);
        
        ArrayList<String> union = new ArrayList<>();
		ArrayList<String> intersection = new ArrayList<>();

        // 교집합 구하기 
		for(String s : list1) {
			if(list2.remove(s)) { 
				intersection.add(s);
			}
			union.add(s);
		}
		
		// 합집합 구하기 
		for(String s : list2) { 
			union.add(s);
		}
        
		double a = intersection.size();
		double b = union.size();

   		double jakard = 0;
	
		if(union.size() == 0)
			jakard = 1;	
		else
			jakard = (double) intersection.size() / (double) union.size();

		return (int) (jakard * 65536);
    }
} 