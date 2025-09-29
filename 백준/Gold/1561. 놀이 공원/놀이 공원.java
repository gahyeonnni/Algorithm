import java.util.*;
import java.io.*;

public class Main {
    static int n, m, answer;
    static int [] array;

    static long count(long x) {
        if (x < 0)
            return 0;
        long sum = m;
        for(int i = 0; i < m; i++) {
            sum += x / array[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int [m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
           array[i] = Integer.parseInt(st.nextToken());
        }
        if (n <= m) {
            System.out.println(n);
            return;
        }
        long left = 0;
        long right = 60000000000L;
        long t = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long people = count(mid);

            if (people >= n) {
                t = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        long before = count(t - 1);

        for (int i = 0; i < m; i++) {
            if (t % array[i] == 0) {
                before++;
                if (before == n) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}
