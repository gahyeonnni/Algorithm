import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static  int [] ramens;
    static long cost = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ramens = new int[n + 2];
        for (int i = 0; i < n; i++) {
            ramens[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (ramens[i + 1] > ramens[i + 2]) {
                int cnt = Math.min(ramens[i], ramens[i + 1] - ramens[i + 2]);
                ramens[i] -= cnt;
                ramens[i + 1] -= cnt;
                cost += 5L * cnt;
            }

            int cnt3 = Math.min(ramens[i], Math.min(ramens[i + 1], ramens[i + 2]));
            ramens[i] -= cnt3;
            ramens[i + 1] -= cnt3;
            ramens[i + 2] -= cnt3;
            cost += 7L * cnt3;

            int cnt2 = Math.min(ramens[i], ramens[i + 1]);
            ramens[i] -= cnt2;
            ramens[i + 1] -= cnt2;
            cost += 5L * cnt2;

            cost += 3L * ramens[i];
            ramens[i] = 0;
        }
        System.out.println(cost);
    }
}