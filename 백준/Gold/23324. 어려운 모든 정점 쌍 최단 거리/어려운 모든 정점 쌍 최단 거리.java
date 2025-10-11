import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        int a = 0;
        int b = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            if (i == k) {
                a = cx;
                b = cy;
                continue;
            }
            list.get(cx).add(cy);
            list.get(cy).add(cx);
        }
        boolean [] visited = new boolean [n+1];
        long x = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(a);
        visited[a] = true;
        while (!dq.isEmpty()) {
            int p = dq.poll();
            x++;
            for (int q : list.get(p)) {
                if (!visited[q]) {
                    visited[q] = true;
                    dq.add(q);
                }
            }
        }
        long y = n - x;
        long answer = x * y;
        System.out.println(answer);
    }
}
