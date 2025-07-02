import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int [][] array = new int [n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));
        int last = 0;

        for (int i = 0; i < n; i++) {
            int start = Math.max(array[i][0], last);
            int end = array[i][1];

            if (start >= end)
                continue;

            int len = end - start;
            int count = (len + l - 1) / l;
            answer += count;
            last = start + count * l;
        }
        System.out.println(answer);
    }
}

