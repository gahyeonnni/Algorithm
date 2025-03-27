import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                list.add(num[i] + num[j]);
            }
        }

        Collections.sort(list);

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int x = num[i] - num[j];
                if (Collections.binarySearch(list, x) >= 0) {
                    System.out.println(num[i]);
                    return;
                }
            }
        }
    }
}
