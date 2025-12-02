import java.io.*;
import java.util.*;

public class Main {
    static int make(String s, int a) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;
        int distinct = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1)
                distinct++;

            while (distinct > a) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0)
                    distinct--;

                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0)
                break;
            String s = br.readLine();
            System.out.println(make(s, a));
        }
    }
}
