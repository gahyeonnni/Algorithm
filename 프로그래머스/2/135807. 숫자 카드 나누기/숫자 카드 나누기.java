import java.io.*; 
import java.util.*; 

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0; 
        Arrays.sort(arrayA); 
        Arrays.sort(arrayB); 
        int ma = arrayA[arrayA.length - 1]; 
        int mb = arrayB[arrayB.length - 1];
        List <Integer> lista = new ArrayList<>();
        List <Integer> listb = new ArrayList<>();
        for (int i = 2; i <= ma; i++) { 
            boolean check = true;
            for (int a : arrayA) {
                if (a % i != 0) {
                    check = !check; 
                    break;
                }
            }
            if (check)
                lista.add(i);
        } 
        for (int i = 2; i <= mb; i++) { 
            boolean check = true;
            for (int a : arrayB) {
                if (a % i != 0) {
                    check = !check; 
                    break;
                }
            }
            if (check)
                listb.add(i);
        } 
        for (int a : lista) {
            boolean check = true;
            for (int x : arrayB) {
                if (x % a == 0) {
                    check = !check; 
                    break;
                }
            }
            if (check) {
                answer = Math.max(answer, a);
            }
        }
        for (int a : listb) {
            boolean check = true;
            for (int x : arrayA) {
                if (x % a == 0) {
                    check = !check; 
                    break;
                }
            }
            if (check) {
                answer = Math.max(answer, a);
            }
        }
        return answer;
    }
}