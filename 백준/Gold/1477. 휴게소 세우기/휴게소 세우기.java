import java.util.*;
import java.io.*;

public class Main {
    static int n, m, line;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        array = new int[n + 2];
        array[0] = 0;
        array[n + 1] = line;

        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(array);

        int left = 1;
        int right = line;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean check(int a) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            int diff = array[i] - array[i - 1];
            if (diff > a) {
                count += (diff - 1) / a;
                if (count > m)
                    return false;
            }
        }
        return true;
    }
}
