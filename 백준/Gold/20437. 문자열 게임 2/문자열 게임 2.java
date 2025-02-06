import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        String [] num = new String [a * 2];

        for (int i = 0; i < num.length; i++){
            num[i] = br.readLine();
        }

        for (int i = 0; i < num.length; i += 2){
            String x = num[i];
            int check = Integer.parseInt(num[i+1]);

            HashMap <Character, Integer> hashmap = new HashMap<>();

            //각각의 문자가 몇개씩 나오는지
            for (char c : x.toCharArray()){
                hashmap.put(c, hashmap.getOrDefault(c,0) + 1);
            }

            boolean ch = false;
            char o;

            Queue <Character> queue = new LinkedList<>();

            //개수가 주어진 정수 이상인 문자들 queue에 넣기
            for (Character n : hashmap.keySet()){
                if (hashmap.get(n) >= check){
                    ch = true;
                    queue.add(n);
                }
            }

            //만족하는 연속 문자열이 없을 시
            if (!ch){
                System.out.println("-1");
                continue;
            }


            int min = Integer.MAX_VALUE;
            int max = 0;

            //어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
            while (!queue.isEmpty()) {
                char ix = queue.poll();
                List<Integer> list = new ArrayList<>();  

                for (int j = 0; j < x.length(); j++) {
                    if (x.charAt(j) == ix) {
                        list.add(j);
                    }
                }

                for (int j = 0; j <= list.size() - check; j++) {
                    int mo = list.get(j + check - 1) - list.get(j) + 1;
                    min = Math.min(min, mo);
                    max = Math.max(max, mo);
                }
            }
            System.out.println(min + " " + max);
        }
    }
}