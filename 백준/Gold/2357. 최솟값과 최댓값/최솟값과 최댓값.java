import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] array;
    static int[] minTree, maxTree;
    static int min, max;
    static final int INF = 1_000_000_001;

    static int treeSize() {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        return 1 << (h + 1);
    }

    static void init(int type, int[] tree, int start, int end, int node) {
        if (start == end) {
            tree[node] = array[start];
        } else {
            int mid = (start + end) / 2;
            init(type, tree, start, mid, node * 2);
            init(type, tree, mid + 1, end, node * 2 + 1);
            if (type == 0)
                tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
            else
                tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    static void query(int type, int[] tree, int start, int end, int node, int l, int r) {
        if (r < start || end < l)
            return;
        if (l <= start && end <= r) {
            if (type == 0)
                min = Math.min(min, tree[node]);
            else
                max = Math.max(max, tree[node]);
            return;
        }
        int mid = (start + end) / 2;
        query(type, tree, start, mid, node * 2, l, r);
        query(type, tree, mid + 1, end, node * 2 + 1, l, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int size = treeSize();
        minTree = new int[size];
        maxTree = new int[size];

        init(0, minTree, 0, n - 1, 1);
        init(1, maxTree, 0, n - 1, 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            min = INF;
            max = -1;
            query(0, minTree, 0, n - 1, 1, a, b);
            query(1, maxTree, 0, n - 1, 1, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
