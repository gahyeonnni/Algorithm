import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int [] array;
    static StringTokenizer st;
    static long total = 0;
    static List<int[]> edges = new ArrayList<>();
    static int find(int x) {
        if (x == array[x])
            return x;
        return array[x] = find(array[x]);
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if (a == b)
            return false;
        array[b] = a;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n + 1];
        for (int i = 1; i <= n; i++)
            array[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
            total += c;
        }
        edges.sort((x, y) -> Integer.compare(x[2], y[2]));

        long m = 0;
        int connect = 0;
       for (int [] e : edges) {
           if (union(e[0], e[1])) {
               m += e[2];
               connect++;
           }
       }

        if (connect == n - 1)
            System.out.println(total - m);
        else
            System.out.println(-1);
    }
}