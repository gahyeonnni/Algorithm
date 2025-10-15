import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringTokenizer st;
    static List <int []> list;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int [] {a, b});
        }

        Collections.sort(list,
                (a,b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
                });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int [] a : list) {
            int x = a[0];
            int y = a[1];

            if (!pq.isEmpty() && x >= pq.peek()) {
                pq.poll();
            }

            pq.add(y);
            answer = Math.max(answer, pq.size());
        }
    System.out.println(answer);
    }
}