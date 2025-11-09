import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static int[] array;
    static int answer = 0;

    static void backTracking(int idx, int sum, boolean picked) {
        if (idx == n) {
            if (picked && sum == s) 
                answer++; 
            return;
        }

        backTracking(idx + 1, sum + array[idx], true);
        backTracking(idx + 1, sum, picked);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) 
            array[i] = Integer.parseInt(st.nextToken());

        backTracking(0, 0, false);
        System.out.println(answer);
    }
}
