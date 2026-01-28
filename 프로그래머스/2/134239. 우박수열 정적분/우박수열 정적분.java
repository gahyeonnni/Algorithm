import java.io.*; 
import java.util.*; 

class Solution {
    static List <Integer> dots;
    static double [] area;
    static int n;
    static Map <Integer, Integer> dotMap;
    
    static void makeOne(int firstNum) {
        while (firstNum != 1) {
            if (firstNum % 2 == 0) {
                firstNum = firstNum / 2; 
                dots.add(firstNum);
            }
            else {
                firstNum = firstNum * 3; 
                firstNum += 1; 
                dots.add(firstNum);
            }
        }
    }
    
    static void makeArea() {
        for (int i = 0; i < n; i++) {
            double count = 0;
            int a1 = i; 
            int a2 = dotMap.get(i); 
            int b1 = a1 + 1; 
            int b2 = dotMap.get(b1); 
            int hei = b1 - a1; 
            double diff = Math.abs(b2 - a2); 
            double max = Math.max(b2, a2); 
            count += (max - diff) * hei;
            double triangle = (diff * hei) / 2;
            count += triangle;
            area[i] = count;
        }
    }
    
    static void makeAnswer(double [] answer, int [][] ranges) {
        for (int i = 0; i < ranges.length; i++) {
            int x = ranges[i][0];
            int b = ranges[i][1];
            int end = n + b;
            
            if (x > end) {
                answer[i] = -1.0;
                continue;
            } 
            if (x == end) {
                answer[i] = 0.0; 
                continue;
            }
            double total = 0.0; 
            for (int j = x; j < end; j++)
                total += area[j]; 
            answer[i] = total;
        }
    }
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double [ranges.length]; 
        dots = new ArrayList<>(List.of(k)); 
        makeOne(k);  
        int index = 0; 
        dotMap = new LinkedHashMap<>();
        for (int dot : dots) {
            dotMap.put(index++, dot);
        }
        n = dots.size() - 1;
        area = new double [n]; 
        makeArea(); 
        makeAnswer(answer, ranges);
        return answer;
    }
}