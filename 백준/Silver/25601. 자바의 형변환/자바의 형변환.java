import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int answer;
    static boolean bfs(String s, String x, Map <String, List<String>> map) {
        Queue <String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            String a = queue.poll();
            if (!map.containsKey(a))
                continue;
            List <String> list = map.get(a);
            for (String b : list) {
                if (b.equals(x))
                    return true;
                queue.add(b);
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map <String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String x = st.nextToken();
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(x);
        }
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String x = st.nextToken();
        if (bfs(s, x, map) || bfs(x, s, map))
            answer = 1;
        else
            answer = 0;
        System.out.println(answer);
    }
}


