import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<int[]> num = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            num.add(new int[]{q, w});
        }
        Collections.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return Integer.compare(o1[0], o2[0]); 
                else
                    return Integer.compare(o1[1], o2[1]); 
            }
        });

        int count = 0;
        int lastEndTime = 0;
        
        for (int i = 0; i < a; i++) {
            if (num.get(i)[0] >= lastEndTime) {
                lastEndTime = num.get(i)[1];
                count++;
            }
        }
        System.out.println(count);
    }
}