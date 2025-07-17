import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int n, s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int [] array = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (true) {
            if (sum >= s) {
                minLen = Math.min(minLen, right - left);
                sum -= array[left++];
            }
            else if (right == n) {
                break;
            }
            else
                sum += array[right++];
        }
        if (minLen == Integer.MAX_VALUE)
            answer = 0;
        else
            answer = minLen;
        System.out.println(answer);
    }
}