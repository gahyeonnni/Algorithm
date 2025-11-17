import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); 
            arr[i][1] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int maxH = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][1] > maxH) {
                maxH = arr[i][1];
                maxIndex = i;
            }
        }

        int curH = arr[0][1];
        int curX = arr[0][0];

        for (int i = 1; i <= maxIndex; i++) {
            if (arr[i][1] >= curH) {
                answer += (arr[i][0] - curX) * curH;
                curH = arr[i][1];
                curX = arr[i][0];
            }
        }

        curH = arr[n-1][1];
        curX = arr[n-1][0];

        for (int i = n-2; i >= maxIndex; i--) {
            if (arr[i][1] >= curH) {
                answer += (curX - arr[i][0]) * curH;
                curH = arr[i][1];
                curX = arr[i][0];
            }
        }

        answer += maxH;

        System.out.println(answer);
    }
}
