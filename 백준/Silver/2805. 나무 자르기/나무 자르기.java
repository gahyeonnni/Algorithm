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
        int left = 0; int right = 1;
        for (int i = 0; i < N; i++){
            arr[i] =  Integer.parseInt(y[i]);
            right = Math.max(arr[i], right);
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            long a = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] >= mid)
                    a += arr[i] - mid;
            }
            if (a < M)
                right = mid - 1;
            else
                left = mid + 1;
        }
        System.out.println(right);
    }
}
