import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int [] array = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());

        int summax = Integer.MIN_VALUE;
        int start = 0;
        int last = array.length - 1;

        while (true) {
            int len = last - start - 1;
            int a = len * Math.min(array[start], array[last]);
            summax = Math.max(a, summax);
            if (array[start] < array[last])
                start++;
            else
                last--;
            if (start >= last)
                break;
        }
        System.out.println(summax);
    }
}