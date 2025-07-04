import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int answer = 0;

        List<Integer> a = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        TreeMap<Integer,Integer> b = new TreeMap<>();
        StringTokenizer stb = new StringTokenizer(br.readLine());
        while (stb.hasMoreTokens()) {
            int x = Integer.parseInt(stb.nextToken());
            b.put(x, b.getOrDefault(x, 0) + 1);
        }

        Collections.sort(a);
        List<Integer> leftoverA = new ArrayList<>();
        for (int x : a) {
            Integer lower = b.lowerKey(x);
            if (lower != null) {
                answer += 2;
                int cnt = b.get(lower);
                if (cnt == 1)
                    b.remove(lower);
                else
                    b.put(lower, cnt - 1);
            }
            else {
                leftoverA.add(x);
            }
        }
        for (int x : leftoverA) {
            Integer cnt = b.get(x);
            if (cnt != null) {
                answer += 1;
                if (cnt == 1)
                    b.remove(x);
                else
                    b.put(x, cnt - 1);
            }
        }

        System.out.println(answer);
    }
}
