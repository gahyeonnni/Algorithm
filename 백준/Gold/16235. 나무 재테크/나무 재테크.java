import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int [][] A;
    static LinkedList<Integer>[][] trees; //나무
    static int [][] plus; //양분
    static int [] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int [] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //땅 크기
        m = Integer.parseInt(st.nextToken()); //맨 처음 나무 묘목 개수
        k = Integer.parseInt(st.nextToken()); //k년이 지난 후
        A = new int [n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = 0;
            while (st.hasMoreTokens()) {
                A[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        trees = (LinkedList<Integer>[][]) new LinkedList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                trees[i][j] = new LinkedList<>();
            }
        }
        plus = new int [n][n];

        //초기 나무 심음
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees[x][y].add(z);
        }
        //가장 처음에 양분은 모든 칸에 5만큼
        for (int i = 0; i < n; i++)
            Arrays.fill(plus[i], 5);


        for (int i = 0; i < k; i++) {
            springSummer();
            fall(); 
            winter();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!trees[i][j].isEmpty()) {
                    answer += trees[i][j].size();
                }
            }
        }

        System.out.println(answer);
    }

    private static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                plus[i][j] += A[i][j];
            }
        }
    }

    private static void fall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!trees[i][j].isEmpty()) {
                    for (int a : trees[i][j]) {
                        if (a % 5 == 0) {
                            makeTree(i, j);
                        }
                    }
                }
            }
        }
    }

    private static void makeTree(int i, int j) {
        for (int k = 0; k < 8; k++) {
            int a = i + dx[k];
            int b = j + dy[k];
            if (a >= 0 && b >= 0 && a < n && b < n) {
                trees[a][b].addFirst(1);
            }
        }
    }

    private static void springSummer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (trees[i][j].isEmpty())
                    continue;

                Collections.sort(trees[i][j]);
                LinkedList<Integer> next = new LinkedList<>();
                int addVitamin = 0;
                boolean dead = false;

                for (int age : trees[i][j]) {
                    if (!dead && plus[i][j] >= age) {
                        plus[i][j] -= age;
                        next.add(age + 1);
                    }
                    else {
                        dead = true;
                        addVitamin += age / 2;
                    }
                }

                plus[i][j] += addVitamin;
                trees[i][j] = next;
            }
        }
    }
}