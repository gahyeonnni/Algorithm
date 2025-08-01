import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List<int[]>[] makeFrom;
    static int[] indegree;
    static Map<Integer, Integer>[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        makeFrom = new ArrayList[n + 1];
        indegree = new int[n + 1];
        result = new Map[n + 1];

        for (int i = 1; i <= n; i++) {
            makeFrom[i] = new ArrayList<>();
            result[i] = new HashMap<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            makeFrom[y].add(new int[]{x, k});
            indegree[x]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result[i].put(i, 1);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int[] next : makeFrom[cur]) {
                int nextPart = next[0];
                int count = next[1];

                for (int key : result[cur].keySet()) {
                    int total = result[nextPart].getOrDefault(key, 0) + result[cur].get(key) * count;
                    result[nextPart].put(key, total);
                }

                indegree[nextPart]--;
                if (indegree[nextPart] == 0) {
                    q.offer(nextPart);
                }
            }
        }

        List<Integer> keys = new ArrayList<>(result[n].keySet());
        Collections.sort(keys);
        for (int key : keys) {
            System.out.println(key + " " + result[n].get(key));
        }
    }
}
