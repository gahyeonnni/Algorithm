import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int party = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>(); //진실을 아는 사람들
        if (Integer.parseInt(st.nextToken()) == 0) {
            System.out.println(party);
            return;
        }
        else {
            while (st.hasMoreTokens()) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }
        Queue <int []> queue = new LinkedList<>();
        for (int i = 0; i < party; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int [] check = new int [count]; //파티에 참가한 사람들
            int index = 0;
            while (st.hasMoreTokens()) {
                check[index++] = Integer.parseInt(st.nextToken());
            }
            boolean liecheck = false;
            for (int j : check) {
                if (set.contains(j)) {
                    liecheck = true;
                    break;
                }
            }
            if (!liecheck) //파티에 진실을 아는 사람 존재 X
                queue.add(check);
            else { //진실 아는 사람 O -> set에 다 추가하기
                for (int k : check) {
                    set.add(k);
                }
            }
        }
        boolean change = true;
        while (change) {
            change = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] x = queue.poll();
                boolean contain = false;
                for (int person : x) {
                    if (set.contains(person)) {
                        contain = true;
                        break;
                    }
                }
                if (contain) { //진실을 아는 사람이 포함된 경우
                    for (int person : x) {
                        if (set.add(person)) {
                            change = true;
                        }
                    }
                }
                else
                    queue.add(x);
            }
        }
        System.out.println(queue.size());
    }
}
