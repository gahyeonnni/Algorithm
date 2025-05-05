import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            max = Math.max(max, M);

            list.add(new int[]{N, M});

            map.put(N, map.getOrDefault(N, 0) + 1);
            map.put(M, map.getOrDefault(M, 0) - 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        int sum = 0;
        int ans = 0;
        int start = 0;
        int end = 0;
        boolean ch = false;

        for (int time : keyList) {
            sum += map.get(time);

            if (sum > ans) {
                ans = sum;
                start = time;
                ch = true;
            }
            else if (sum < ans && ch) {
                end = time;
                ch = false;
            }
        }

        if (ch)
            end = keyList.get(keyList.size() - 1);

        System.out.println(ans);
        System.out.println(start + " " + end);
    }
}
