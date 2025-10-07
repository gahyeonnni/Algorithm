import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            queue.add(0);
        }
        for (int i = n - 1; i >= 0; i--) {
            int a = queue.poll();
            a += arr[i];
            queue.add(a);
        }
        while (!queue.isEmpty()) {
            ans = Math.max(ans, queue.poll());
        }
        System.out.println(ans);
    }
}

