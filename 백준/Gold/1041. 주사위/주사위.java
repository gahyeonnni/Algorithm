import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringTokenizer st;
    static int [] array;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int [6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0; 
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int x : array) 
        { 
            sum += x;
            max = Math.max(max, x); 
            min = Math.min(min, x); 
        }
        if (n == 1) {
            answer = sum - max;
        }
        else {
            long min1 = min;
            long min2 = findMin2(array);
            long min3 = findMin3(array);

            answer = 4 * min3 + (8L * n - 12) * min2 + (5L * n - 6) * (n - 2) * min1;
        }
        System.out.println(answer);
    }

    static int findMin2(int[] a) {
        int min = Integer.MAX_VALUE;
        int[][] pair = {
                {0, 1}, {0, 2}, {0, 3}, {0, 4},
                {1, 2}, {1, 3}, {1, 5},
                {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}
        };
        for (int[] p : pair)
            min = Math.min(min, a[p[0]] + a[p[1]]);
        return min;
    }

    static int findMin3(int[] a) {
        int min = Integer.MAX_VALUE;
        int[][] tri = {
                {0,1,2}, {0,1,3}, {0,2,4}, {0,3,4},
                {5,1,2}, {5,1,3}, {5,2,4}, {5,3,4}
        };
        for (int[] t : tri)
            min = Math.min(min, a[t[0]] + a[t[1]] + a[t[2]]);
        return min;
    }
}
