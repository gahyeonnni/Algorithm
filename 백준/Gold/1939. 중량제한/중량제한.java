import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<int[]>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] info = new int[3];
            info[0] = Integer.parseInt(st.nextToken());
            info[1] = Integer.parseInt(st.nextToken());
            info[2] = Integer.parseInt(st.nextToken());
            max = Math.max(max, info[2]);

            edges.get(info[0]).add(new int[]{info[1], info[2]});
            edges.get(info[1]).add(new int[]{info[0], info[2]});
        }

        int[] bridge = new int[2];
        st = new StringTokenizer(br.readLine());
        bridge[0] = Integer.parseInt(st.nextToken());
        bridge[1] = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = max;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(bridge[0], bridge[1], mid)) {
                ans = mid;
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int a, int b, int mid) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == b) 
                return true;

            for (int[] x : edges.get(cur)) {
                int next = x[0];
                int weight = x[1];
                if (weight >= mid && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return false;
    }
}
