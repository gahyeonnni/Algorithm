import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List <List <Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [] array = new int [n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = bfs(array);
        System.out.println(answer);
    }

    static void change(int[] array, List<Integer> switchList, int switchIndex) {
        for (int i : switchList) {
            array[i] = (array[i] + (switchIndex + 1)) % 5;
        }
    }

    static boolean check(int[] arr) {
        int first = arr[1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] != first)
                return false;
        }
        return true;
    }

    static String makeKey(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(arr[i]);
        return sb.toString();
    }

    static int bfs(int [] array) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(array.clone());
        depth.add(0);
        visited.add(makeKey(array));

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int step = depth.poll();

            if (check(cur))
                return step;

            for (int i = 0; i < m; i++) {
                int[] next = cur.clone();
                change(next, list.get(i), i);
                String key = makeKey(next);

                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(next);
                    depth.add(step + 1);
                }
            }
        }
        return -1;
    }
}