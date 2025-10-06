import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List <Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        Queue<Long> queue = new LinkedList<>();
        List <Long> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++)
            queue.add((long) i);
        while (!queue.isEmpty()) {
            long a = queue.poll();
            list.add(a);
            for (int i = 0; i < a % 10; i++) {
                long x = 0;
                x += a * 10;
                x += i;
                queue.add(x);
            }
        }
        Collections.sort(list);
        if (list.size() <= n - 1)  {
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(n-1));
    }
}