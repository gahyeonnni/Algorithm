import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, count = 0;

        while (start <= end && end <= N) {
            if (sum < M) {
                if (end < N) {
                    sum += arr[end++];
                } else {
                    break;
                }
            } else {
                if (sum == M) {
                    count++;
                }
                sum -= arr[start++];
            }
        }

        System.out.println(count);
    }
}
