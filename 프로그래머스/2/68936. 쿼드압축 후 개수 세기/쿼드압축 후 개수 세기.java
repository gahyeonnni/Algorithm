class Solution {
    static int n;
    static int[] answer;

    static boolean allSame(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) 
                    return false;
            }
        }
        return true;
    }

    static void quad(int[][] arr, int x, int y, int size) {
        if (allSame(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        int half = size / 2;
        quad(arr, x, y, half);                 
        quad(arr, x, y + half, half);         
        quad(arr, x + half, y, half);          
        quad(arr, x + half, y + half, half);   
    }

    public int[] solution(int[][] arr) {
        n = arr.length;
        answer = new int[2];
        quad(arr, 0, 0, n);
        return answer;
    }
}
