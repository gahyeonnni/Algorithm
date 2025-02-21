import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] x = br.readLine().split(" ");
        int N = Integer.parseInt(x[0]);
        int M = Integer.parseInt(x[1]);
        int [] arr = new int [N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long left = 1;
        long right = arr[N - 1];

        while (left <= right){
            long mid = (right + left) / 2;
            long count = 0;
            for (int i = 0; i < N; i++)
                count += arr[i] / mid;
            if (count >= M){
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        System.out.println(right);
    }
}
