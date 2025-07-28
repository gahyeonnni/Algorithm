import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> temp = new ArrayList<>();
            while (true) {
                int val = Integer.parseInt(st.nextToken());
                if (val == -1)
                    break;
                temp.add(val);
            }
            if (!temp.isEmpty()) {
                int key = temp.get(0);
                List<Integer> value = new ArrayList<>(temp.subList(1, temp.size()));
                list.add(new AbstractMap.SimpleEntry<>(key, value));
            }
        }
        int [] hour = new int [n];
        boolean [] check = new boolean [n];

        while (true) {
            boolean c = false;

            for (int i = 0; i < n; i++) {
                if (check[i])
                    continue;
                Map.Entry<Integer, List<Integer>> map = list.get(i);
                List<Integer> val = map.getValue();

                int max = 0;
                boolean ready = true;
                for (int dep : val) {
                    if (!check[dep - 1]) {
                        ready = false;
                        break;
                    }
                    max = Math.max(max, hour[dep - 1]);
                }
                if (ready) {
                    hour[i] = max + map.getKey();
                    check[i] = true;
                    c = true;
                }
            }
                    if (!c)
                        break;
            }
            for (int a : hour) {
                System.out.println(a);
            }
    }
}
