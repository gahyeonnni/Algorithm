import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(br.readLine());
        Map <String, Integer> map = new HashMap<>();
        List <String> list = new LinkedList<>();
        for (int i = 0; i < a; i++) {
            String str = br.readLine();
            list.add(str);
        }
        for (String x : list) {
            int p = 1;
            for (int i = x.length() - 1; i >= 0; i--) {
                String one = String.valueOf(x.charAt(i));
                map.put(one, map.getOrDefault(one, 0) + p);
                p *= 10;
            }
        }
        List <Map.Entry<String, Integer>> lst = new ArrayList<>(map.entrySet());
        lst.sort((e1,e2) -> e2.getValue().compareTo(e1.getValue()));
        Map <String, Integer> numvalue = new HashMap<>();
        int score = 9;
        for (Map.Entry<String, Integer> entry : lst) {
            numvalue.put(entry.getKey(), score);
            score--;
            if (score < 0)
                break;
        }
        int sum = 0;
        for (String x : list) {
            int len = x.length();
            int num = 0;
            for (int i = 0; i < len; i++) {
                num = num * 10 + numvalue.get(String.valueOf(x.charAt(i)));
            }
            sum += num;
        }
        System.out.println(sum);
    }
}