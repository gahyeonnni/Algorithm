import java.io.*; 
import java.util.*; 

class Solution {
    /*
    static void makeArr(int [][] arr, int num) {
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= num; j++) {
                if (arr[i][j] == 0)
                    arr[i][j] = num + 1;
            }
        }    
    } */
    
    public int[] solution(int n, long left, long right) {
        int[] answer = new int [(int)(right - left + 1)];
        
        int idx = 0;
        for (long i = left; i <= right; i++) {
            int row = (int)(i / n); 
            int col = (int)(i % n);
            answer[idx++] = Math.max(row, col) + 1;
        }
        
        /*
        
        123
        223
        333
        
        -> 1 2 3 2 2 3 3 3 3
        -> 0 1 2 3 4 5 6 7 8 
        
        -> i / n 
        -> i % n 
        

        */
        /*
        //1. n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
        //int [][] arr = new int [n][n]; 
        
        //2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
        for (int i = 0; i < n; i++) {
            makeArr(arr, i);
        }
        //1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
        List <Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int [] oneArr = arr[i];
            for (int j = 0; j < oneArr.length; j++)
                numbers.add(oneArr[j]);
        }
        int idx = 0;
        for (long i = left; i <= right; i++) {
            answer[idx++] = numbers.get((int)i);
        } */
        
        return answer;
    }
}