import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] array;

    public static int findMin(int start) {
        int idx = start;
        int minCost = Integer.MAX_VALUE;
        for (int i = start; i < n; i++) {
            if (array[i] < minCost) {
                minCost = array[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());

        int min = findMin(0);

        if (m < array[min]) {
            System.out.println(0);
            return;
        }

        int firstDigit;
        if (min == 0 && n > 1) {
            int second = findMin(1);
            if (array[second] > m) {
                System.out.println(0);
                return;
            }
            firstDigit = second;
            m -= array[second];
        } else {
            firstDigit = min;
            m -= array[min];
        }

        int length = 1 + (m / array[min]);
        int[] result = new int[length];
        result[0] = firstDigit;
        for (int i = 1; i < length; i++) {
            result[i] = min;
            m -= array[min];
        }

        for (int i = 0; i < length; i++) {
            for (int d = n - 1; d >= 0; d--) {
                int diff = array[d] - array[result[i]];
                if (diff <= m && diff >= 0) {
                    m -= diff;
                    result[i] = d;
                    break;
                }
            }
        }

        for (int x : result) System.out.print(x);
    }
}
