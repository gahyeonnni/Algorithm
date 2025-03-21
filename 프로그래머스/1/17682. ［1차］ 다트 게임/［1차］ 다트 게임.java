import java.util.*;
import java.io.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List <Integer> list = new LinkedList<>();
        boolean ch = true;
        for (int i = 0; i < dartResult.length(); i++) {
            char x = dartResult.charAt(i);
            if (!ch){
                ch = !ch;
                continue;
            }
            if (Character.isDigit(x) && !Character.isDigit(dartResult.charAt(i+1))) {
                String x1 = String.valueOf(x);
                list.add(Integer.parseInt(x1));
            }  
            else if (x == '1' && dartResult.charAt(i + 1) == '0' && i != dartResult.length()) {
                ch = false;
                list.add(10);
            }
            else {
                if (x == '*') {
                    if (list.size() == 1) {
                        int a = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(a * 2); 
                    }
                    else {
                        int a = list.get(list.size() - 1);
                        int b = list.get(list.size() - 2);
                        list.remove(list.size() - 2);
                        list.remove(list.size() - 1);
                        list.add(b * 2);
                        list.add(a * 2);
                    }
                }
                else if (x == '#') {
                   if (list.size() != 0) {
                        int a = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(a * -1); 
                    } 
                }
                else if (x == 'S') {
                    continue;
                } 
                else if (x == 'T') {
                    if (list.size() != 0) {
                        int a = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(a * a * a); 
                    }  
                }
                else if (x == 'D') {
                    if (list.size() != 0) {
                        int a = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(a * a); 
                    }  
                } 
            } 
        }
        for (int i : list)
            answer += i;
        return answer;
    }
}