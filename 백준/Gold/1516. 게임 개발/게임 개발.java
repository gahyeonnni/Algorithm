import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringTokenizer st;
    static List <List <Integer>> list;
    static boolean check(boolean [] visited) {
        for (boolean x : visited) {
            if (!x)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        int [] array = new int [n];
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            array[i] = a;
            while (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1)
                    break;
                list.get(i).add(x - 1);
            }
        }

        boolean [] visited = new boolean [n];
        for (int i = 0; i < n; i++)  {
            if (list.get(i).size() == 0)
                visited[i] = true;
        }

        while (true) {
            if (check(visited))
                break;

            for (int i = 0; i < n; i++) {
                if (visited[i])
                    continue;

                List <Integer> x = list.get(i);
                boolean check = true;

                for (int j : x) {
                    if (!visited[j]) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    int max = 0;
                    for (int j : x) {
                        max = Math.max(max, array[j]);
                    }
                    array[i] += max;
                    visited[i] = true;
                }
            }
        }
        for (int a : array)
            System.out.println(a);
    }
}

