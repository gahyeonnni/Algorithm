import java.util.*;
import java.io.*;

public class Main {
    static int n, l, r, x;
    static int [] array;
    static StringTokenizer st;
    static int answer = 0;
    static int sum (List <Integer> list) {
        int sum = 0;
        for (int a : list)
            sum += a;
        return sum;
    }
    static void dfs(int [] array, boolean [] check, List <Integer> list, int start) {
        if (list.size() >= 2) {
            int s = sum(list);
            int max = Collections.max(list);
            int min = Collections.min(list);

            if (s >= l && s <= r && (max - min) >= x) {
                answer++;
            }
        }

        for (int i = start; i < array.length; i++) {
            if (!check[i]) {
                check[i] = true;
                list.add(array[i]);
                dfs(array, check, list, i + 1);
                check[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        array = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());
        boolean [] check = new boolean [n];
        List <Integer> list = new LinkedList<>();
        dfs(array, check, list, 0 );
        System.out.println(answer);
    }
}