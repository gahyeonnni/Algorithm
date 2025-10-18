import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static StringTokenizer st;
    static int [][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int [n][2];
        int sum = 0;
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[i][0] = a;
            array[i][1] = b;
            sum += b;
            int gain = a - b;
            if (gain > 0)
                diff.add(gain);
        }
        m -= 1000 * n;
        if (m < 0) {
            System.out.println(sum);
            return;
        }
        
        Collections.sort(diff, Collections.reverseOrder());

        int k = Math.min(m / 4000, diff.size());

        for (int i = 0; i < k; i++) {
            sum += diff.get(i);
        }

        System.out.println(sum);
    }
}
