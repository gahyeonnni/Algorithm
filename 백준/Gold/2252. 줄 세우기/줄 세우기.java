import java.util.*;
import java.io.*;

public class Main {
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] g = new ArrayList[a + 1];
        for (int i = 0; i <= a; i++)
            g[i] = new ArrayList<>();
        int[] indeg = new int[a + 1];

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            g[p].add(q);
            indeg[q]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= a; i++)
            if (indeg[i] == 0)
                q.add(i);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');
            for (int nxt : g[cur]) {
                if (--indeg[nxt] == 0)
                    q.add(nxt);
            }
        }

        System.out.println(sb.toString().trim());
    }
}

