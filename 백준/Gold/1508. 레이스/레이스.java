import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m, k;
    static int [] position;
    static boolean canmove(int mid) {
        int count = 1;
        int left = position[0];
        for (int i = 1; i < k; i++) {
            if (position[i] - left >= mid) {
                count++;
                left = position[i];
                if (count >= m)
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        position = new int [k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            position[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(position);

        int left = 1;
        int right = n;
        int max = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canmove(mid)) {
                max = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        boolean [] check = new boolean [k];
        int count = 1;
        int last = position[0];
        check[0] = true;
        for (int i = 1; i < k && count < m; i++) {
            if (position[i] - last >= max) {
                check[i] = true;
                last = position[i];
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (check[i])
                sb.append(1);
            else
                sb.append(0);
        }
        System.out.println(sb);
    }
}
