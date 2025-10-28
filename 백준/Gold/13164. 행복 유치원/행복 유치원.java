import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] array = new int [n];
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());

        int [] diff = new int [n - 1];
        for (int i = 0; i < n - 1; i++)
            diff[i]  = array[i + 1] - array[i];

        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < n - m; i++)
            answer += diff[i];

        System.out.println(answer);
    }
}
