import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int [][] cost = new int [n][2];
        int time = 0;
        int a = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cost, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(cost[i][1]);
            if (pq.size() > cost[i][0])
                pq.poll();
        }
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
