import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = b;
            arr[i][1] = c;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]); 
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 
        for (int i = 0; i < N; i++) {
            if (!priorityQueue.isEmpty() && priorityQueue.peek() <= arr[i][0])
                priorityQueue.poll(); 
            priorityQueue.offer(arr[i][1]);
        }
        System.out.println(priorityQueue.size());
    }
}
