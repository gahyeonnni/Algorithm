import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int a, b, num;
    static List<Integer> list;
    static int dong;

    static int toDistance(int r, int s) {
        if (r == 1)
            return s;
        else if (r == 4)
            return a + s;
        else if (r == 2)
            return a + b + (a - s);
        else
            return 2 * a + b + (b - s);
    }

    static int clock(int p1, int p2) {
        return Math.abs(p1 - p2);
    }

    static int reverseClock(int p1, int p2) {
        int perimeter = 2 * (a + b);
        return perimeter - Math.abs(p1 - p2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(toDistance(r, s));
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        dong = toDistance(r, s);

        int total = 0;
        for (int store : list) {
            total += Math.min(clock(store, dong), reverseClock(store, dong));
        }

        System.out.println(total);
    }
}
