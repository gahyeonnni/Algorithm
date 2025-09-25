import java.io.*; 
import java.util.*; 

class Solution {  
    static boolean fourblockscheck(String[][] board, int m, int n) {
        boolean result = false; 
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!board[i][j].equals("")) {
                    if (board[i][j].equals(board[i][j+1]) &&
                        board[i][j].equals(board[i+1][j]) &&
                        board[i][j].equals(board[i+1][j+1])) {
                        return true;
                    }
                }
            }
        }
        return result;
    } 
    
    static boolean fourblock(int i, int j, String[][] board) {
        if (board[i][j].equals(board[i][j+1]) &&
            board[i][j].equals(board[i+1][j]) &&
            board[i][j].equals(board[i+1][j+1])) {
            return true; 
        }
        else {
            return false;
        }
    }
    
    static String[][] moveboard(String[][] board) {
        int m = board.length;     
        int n = board[0].length;  

        for (int j = 0; j < n; j++) {  
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < m; i++) {
                if (!board[i][j].equals("")) {
                    stack.push(board[i][j]);
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                if (!stack.isEmpty()) {
                    board[i][j] = stack.pop();
                } 
                else {
                    board[i][j] = "";
                }
            }
        }
        return board; 
    }

    
    public int solution(int m, int n, String[] inputBoard) {
        String[][] board = new String[m][n];
        for (int i = 0; i < m; i++) {
            String row = inputBoard[i];
            for (int j = 0; j < n; j++) {
                board[i][j] = String.valueOf(row.charAt(j));
            }
        }

        int answer = 0;
        while (fourblockscheck(board, m, n)) {
            Set <String> hashset = new HashSet<>(); 
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (!board[i][j].equals("") && fourblock(i, j, board)) {
                        hashset.add(i + "," + j);
                        hashset.add((i+1) + "," + j);
                        hashset.add(i + "," + (j+1));
                        hashset.add((i+1) + "," + (j+1));
                    }
                }
            }
            answer += hashset.size(); 
            for (String pos : hashset) {
                String[] parts = pos.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                board[x][y] = "";
            } 
            board = moveboard(board);
        }
        return answer;
    }
}
