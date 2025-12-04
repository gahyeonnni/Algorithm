import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] crain = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            crain[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            box.add(Integer.parseInt(st.nextToken()));

        Arrays.sort(crain, Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if (crain[0] < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        while (!box.isEmpty()) {
            int idx = 0;

            for (int i = 0; i < n; i++) {
                if (idx >= box.size())
                    break;

                if (crain[i] >= box.get(idx)) {
                    box.remove(idx);
                }
                else {
                    idx++;
                    i--;
                }
            }

            time++;
        }

        System.out.println(time);
    }
}
