import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        Collections.sort(list,
                (a, b) -> {
                    if (b[1] == a[1]) //마감 기한 같으면
                        return b[0] - a[0]; //할 일이 더 많은 순서대로
                    return a[1] - b[1]; //마감기한이 짧은 순서대로
                });

        int[] x = list.get(n - 1);
        int b = x[1];
        int total = b;

        for (int i = n - 1; i >= 0; i--) {
            int[] p = list.get(i);
            int q = p[0];
            int w = p[1];

            total = Math.min(total, w);
            total -= q; 

            if (total < 0) {
                System.out.println(-1);
                return;
            }

        }
        System.out.println(total);
    }
}
