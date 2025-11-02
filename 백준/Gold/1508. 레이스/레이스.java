import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m, k;
    static int[] array;
    static boolean canPlace(int d) {
        int count = 1;
        int max = array[0];
        for (int i = 1; i < k; i++) {
            if (array[i] - max >= d) {
                count++;
                max = array[i];
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

        array = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int len = 1;
        int rig = n;
        int max = 0;
        while (rig >= len) {
            int mid = (len + rig) / 2;
            if (canPlace(mid)) {
                max = mid;
                len = mid + 1;
            }
            else
                rig = mid - 1;
        }

        boolean [] check = new boolean [k];
        int count = 1;
        int last = array[0];
        check[0] = true;
        for (int i = 1; i < k && count < m; i++) {
            if (array[i] - last >= max) {
                check[i] = true;
                last = array[i];
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (check[i]) {
                sb.append(1);
            }
            else
                sb.append(0);
        }

        System.out.println(sb);
    }
}
