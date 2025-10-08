import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringTokenizer st;
    static int[][] array;

    static boolean allclass(int[][] array, int mid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int start = array[i][0];
            int end = array[i][1];

            if (!pq.isEmpty() && pq.peek() <= start)
                pq.poll();

            pq.add(end);

            if (pq.size() > mid) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            array[i][0] = start;
            array[i][1] = end;
        }

        Arrays.sort(array, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int left = 1;
        int right = n; 
        int answer = n;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (allclass(array, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
