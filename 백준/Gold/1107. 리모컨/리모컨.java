import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int dest;
    static int n;
    static int [] array;
    static StringTokenizer st;
    static int cur = 100;
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dest = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        array = new int[10];

        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                array[num] = 1;
            }
        }

        count = Math.abs(dest - cur);

        for (int i = 0; i < 999999; i++) {
            int len = calculateLen(i);
            if (len > 0)
                count = Math.min(count, len + Math.abs(dest - i));
        }
        System.out.println(count);
    }

    private static int calculateLen(int i) {
        if (i == 0) {
            if (array[i] == 1)
                return 0;
            return 1;
        }

        int len = 0;
        while (i > 0) {
            int k = i % 10;
            if (array[k] == 1)
                return 0;
            len++;
            i /= 10;
        }
        return len;
    }
}
