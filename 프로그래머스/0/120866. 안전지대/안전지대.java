import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = 0;

        int[] dx = {-1, -1, -1,  0, 0, 1, 1, 1};
        int[] dy = {-1,  0,  1, -1, 1,-1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && board[ni][nj] == 0) {
                            board[ni][nj] = 2;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) answer++;
            }
        }

        return answer;
    }
}
