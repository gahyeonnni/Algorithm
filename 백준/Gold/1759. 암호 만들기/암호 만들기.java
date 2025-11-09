import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static List<List<Character>> finalMo;
    static List<List<Character>> finalJa;
    static List<Character> ja;
    static List<Character> mo;
    static List<Character> molist = List.of('a', 'e', 'i', 'o', 'u');

    static void makemo(List<Character> listmo, int a, int num, int x) {
        if (num == a) {
            finalMo.add(new ArrayList<>(listmo));
            return;
        }
        for (int i = x; i < mo.size(); i++) {
            List<Character> newList = new ArrayList<>(listmo);
            newList.add(mo.get(i));
            makemo(newList, a, num + 1, i + 1);
        }
    }

    static void makeja(List<Character> listja, int a, int num, int x) {
        if (num == a) {
            finalJa.add(new ArrayList<>(listja));
            return;
        }
        for (int i = x; i < ja.size(); i++) {
            List<Character> newList = new ArrayList<>(listja);
            newList.add(ja.get(i));
            makeja(newList, a, num + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        mo = new ArrayList<>();
        ja = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            char ch = st.nextToken().charAt(0);
            if (molist.contains(ch)) mo.add(ch);
            else ja.add(ch);
        }

        Collections.sort(mo);
        Collections.sort(ja);

        finalMo = new ArrayList<>();
        finalJa = new ArrayList<>();

        List<int[]> comb = new ArrayList<>();
        for (int a = 1; a <= mo.size(); a++) {
            int b = l - a;
            if (b >= 2 && b <= ja.size()) {
                comb.add(new int[]{a, b});
            }
        }

        List <String> ans = new ArrayList<>();
        for (int[] ab : comb) {
            int a = ab[0];
            int b = ab[1];
            finalMo.clear();
            finalJa.clear();
            makemo(new ArrayList<>(), a, 0, 0);
            makeja(new ArrayList<>(), b, 0, 0);

            for (List<Character> m : finalMo) {
                for (List<Character> j : finalJa) {
                    List<Character> merged = new ArrayList<>();
                    merged.addAll(m);
                    merged.addAll(j);
                    Collections.sort(merged);
                    StringBuilder sb = new StringBuilder();
                    for (char ch : merged)
                        sb.append(ch);
                    ans.add(sb.toString());
                }
            }
        }
        Collections.sort(ans);
        for (String x : ans)
            System.out.println(x);
    }
}
