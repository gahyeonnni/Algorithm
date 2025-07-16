import java.util.*;
import java.io.*;

public class Main {
    static int answer = -1;
    static int n, m;
    static int lower(int [] arr, int k) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    static int upper(int [] arr, int k) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());
            xs[i] = xi;
            ys[i] = yi;
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        long sumX = 0, sumY = 0;
        for (int i = 0; i < n; i++) {
            sumX += Math.abs(xs[i]);
            sumY += Math.abs(ys[i]);
        }

        int x = 0, y = 0;
        String command = br.readLine();
        for (char c : command.toCharArray()) {
            switch (c) {
                case 'I':
                    int cntLeX = upper(xs, x);
                    sumX += (long)cntLeX - (n - cntLeX);
                    x++;
                    break;
                case 'Z':
                    int cntLtX = lower(xs, x);
                    sumX += (long)(n - cntLtX) - cntLtX;
                    x--;
                    break;
                case 'S':
                    int cntLeY = upper(ys, y);
                    sumY += (long)cntLeY - (n - cntLeY);
                    y++;
                    break;
                case 'J':
                    int cntLtY = lower(ys, y);
                    sumY += (long)(n - cntLtY) - cntLtY;
                    y--;
                    break;
            }
            System.out.println(sumX + sumY);
        }

    }
}