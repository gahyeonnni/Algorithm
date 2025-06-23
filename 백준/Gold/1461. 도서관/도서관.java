import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > 0)
                plus.add(x);
            else
                minus.add(-x);
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        int answer = 0;
        int max = 0;

        if (!plus.isEmpty())
            max = Math.max(max, plus.get(0));
        if (!minus.isEmpty())
            max = Math.max(max, minus.get(0));

        for (int i = 0; i < plus.size(); i += M) {
            answer += plus.get(i) * 2;
        }

        for (int i = 0; i < minus.size(); i += M) {
            answer += minus.get(i) * 2;
        }
        answer -= max;

        System.out.println(answer);
    }
}
