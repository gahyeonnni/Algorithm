import java.io.*;
import java.util.*;

public class Main {
    static int n, m, c, h, k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map <Integer, List<Integer>> friends = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++)
            friends.put(i, new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            friends.get(p).add(q);
            friends.get(q).add(p);
        }

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //한솔 왕국과의 동맹자들은 전부 true로 표시해둠
        boolean [] check = new boolean [n + 1];
        Queue <Integer> queue = new LinkedList<>();
        queue.add(h);
        check[h] = true;
        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int a : friends.get(k)) {
               if (!check[a]) {
                   queue.add(a);
                   check[a] = true;
               }
            }
        }

        //c가 현재 속해있는 동맹집단 크기 => answer 초기값
        boolean [] checkC = new boolean [n + 1];
        Queue<Integer> queueC = new LinkedList<>();
        queueC.add(c);
        checkC[c] = true;

        int answer = 0;
        while (!queueC.isEmpty()) {
            int cur = queueC.poll();
            answer++;
            for (int a : friends.get(cur)) {
                if (!checkC[a]) {
                    checkC[a] = true;
                    queueC.add(a);
                }
            }
        }
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer> sizes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (check[i])
                continue;
            if (checkC[i])
                continue;
            if (visited[i])
                continue;

            int count = 0;
            Queue <Integer> queue2 = new LinkedList<>();
            queue2.add(i);
            visited[i] = true;
            while (!queue2.isEmpty()) {
                int cur = queue2.poll();
                count++;
                for (int a : friends.get(cur)) {
                    if (check[a])
                        continue;
                    if (checkC[a])
                        continue;
                    if (!visited[a]) {
                        visited[a] = true;
                        queue2.add(a);
                    }
                }
            }
            sizes.add(count);
        }

        sizes.sort(Collections.reverseOrder());
        for (int i = 0; i < k && i < sizes.size(); i++) {
            answer += sizes.get(i);
        }


        System.out.println(answer);
    }
}