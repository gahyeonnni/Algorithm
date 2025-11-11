import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int [n];
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        int left = 0;
        int right = n - 1;
        int count = 0;
        Arrays.sort(array);
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == m) {
                count++;
                left++;
                right--;
            }
            else if (sum < m) {
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println(count);
    }
}
