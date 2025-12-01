import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;

        int leftStart = 1;

        for (int sub : stations) {
            int leftEnd = sub - w;

            if (leftStart < leftEnd) {
                int length = leftEnd - leftStart;

                int count = length / cover;
                if (length % cover != 0)
                    count++;

                answer += count;
            }

            leftStart = sub + w + 1;
        }

        if (leftStart <= n) {
            int length = (n + 1) - leftStart;

            int count = length / cover;
            if (length % cover != 0)
                count++;

            answer += count;
        }

        return answer;
    }
}
