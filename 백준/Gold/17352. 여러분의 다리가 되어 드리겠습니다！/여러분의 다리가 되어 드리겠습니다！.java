import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static boolean [] check;
    static List<List<Integer>> list = new ArrayList<>();
    static int n, x;
    static void dfs(int i) {
        check[i] = true;
        for (int a : list.get(i)) {
            if (!check[a])
                dfs(a);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        x = n - 2;
        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        check = new boolean[n + 1];
        dfs(1);
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                System.out.println("1 " + i);
                break;
            }
        }
    }
}

