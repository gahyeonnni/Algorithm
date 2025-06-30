import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1)
                plus.add(num);
            else if (num == 1)
                ones++;
            else if (num == 0)
                zeros++;
            else minus.add(num);
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        for (int i = 0; i + 1 < plus.size(); i += 2) {
            answer += plus.get(i) * plus.get(i + 1);
        }

        if (plus.size() % 2 == 1)
            answer += plus.get(plus.size() - 1);

        for (int i = 0; i + 1 < minus.size(); i += 2) {
            answer += minus.get(i) * minus.get(i + 1);
        }

        if (minus.size() % 2 == 1) {
            if (zeros == 0)
                answer += minus.get(minus.size() - 1);
        }

        answer += ones;

        System.out.println(answer);
    }
}
