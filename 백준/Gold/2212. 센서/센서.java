import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] array = new int [n];
        int index = 0;
        while (st.hasMoreTokens()) {
            array[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int [] diff = new int [n - 1];
        for (int i = 0; i < n - 1; i++)
            diff[i] = array[i + 1] - array[i];
        if (m >= n) {
            System.out.println(0);
            return;
        }
        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < n - m; i++)
            ans += diff[i];
        System.out.println(ans);
    }
}