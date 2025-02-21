import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] x = br.readLine().split(" ");
        int N = Integer.parseInt(x[0]);
        int M = Integer.parseInt(x[1]);
        int [] arr = new int [N];
        String [] y = br.readLine().split(" ");
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(y[i]);
        }

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (start <= end && end <= N) {
            if (sum < M) {
                if (end < N) {
                    sum += arr[end++];
                } else {
                    break;
                }
            } else {
                len = Math.min(len, end - start);
                sum -= arr[start++];
            }
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
