import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int n, m, x, y, k;
    static int top = 0;
    static int bottom = 0;
    static int east = 0;
    static int west = 0;
    static int north = 0;
    static int south = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] move = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        String string = "";

        for (int dir : move) {
            int nx = x;
            int ny = y;

            if (dir == 1)
                ny += 1;
            else if (dir == 2)
                ny -= 1;
            else if (dir == 3)
                nx -= 1;
            else if (dir == 4)
                nx += 1;

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            x = nx;
            y = ny;
            moveDice(dir);

            if (array[x][y] == 0) {
                array[x][y] = bottom;
            }
            else {
                bottom = array[x][y];
                array[x][y] = 0;
            }
            string += top;
            string += "\n";
        }
        System.out.print(string);
    }

    static void moveDice(int dir) {
        int temptop = top;
        int tempbottom = bottom;
        int tempeast = east;
        int tempwest = west;
        int tempnorth = north;
        int tempsouth = south;

        if (dir == 1) {
            top = tempwest;
            bottom = tempeast;
            east = temptop;
            west = tempbottom;
        }
        else if (dir == 2) {
            top = tempeast;
            bottom = tempwest;
            east = tempbottom;
            west = temptop;
        }
        else if (dir == 3) {
            top = tempsouth;
            bottom = tempnorth;
            north = temptop;
            south = tempbottom;
        }
        else if (dir == 4) {
            top = tempnorth;
            bottom = tempsouth;
            north = tempbottom;
            south = temptop;
        }
    }
}
