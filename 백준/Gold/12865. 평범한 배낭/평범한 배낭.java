import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 물품의 수
        int k = Integer.parseInt(st.nextToken());  // 최대 무게

        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        
        // 아이템의 무게와 가치를 입력 받음
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 선언: dp[i][w]는 i번째 물건까지 고려했을 때, 무게 w 이하에서의 최대 가치
        int[][] dp = new int[n + 1][k + 1];

        // DP로 배낭 문제 해결
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= k; w++) {
                // 현재 물건을 선택할 수 없을 때 (즉, 배낭 무게 w가 현재 물건의 무게보다 작을 때)
                if (weights[i] > w) {
                    dp[i][w] = dp[i - 1][w];  // 이전 물건까지의 최댓값 그대로 가져옴
                } else {
                    // 현재 물건을 선택하는 경우와 선택하지 않는 경우 중 더 큰 가치를 선택
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
                }
            }
        }

        // 최종적으로 n개의 물건을 고려하고, 최대 무게가 k일 때의 최대 가치 출력
        System.out.println(dp[n][k]);
    }
}
