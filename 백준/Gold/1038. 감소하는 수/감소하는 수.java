import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        if (n > 1022) {
            System.out.println(-1);
            return;
        }
        Queue<Long> queue = new LinkedList<>();
        List <Long> list = new ArrayList<>();

        for (int i = 0; i <= 9; i++)
            queue.add((long) i);

        while (!queue.isEmpty()) {
            long a = queue.poll();
            list.add(a);

            long last = a % 10;
            for (long i = 0; i < last; i++) {
                queue.add(a * 10 + i);
            }

        }
        Collections.sort(list);
        System.out.println(list.get(n));
    }
}
