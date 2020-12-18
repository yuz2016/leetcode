package robert.li.bsolution;

public class B_79_exist {
    int[][] direction = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(dfs(board, visited, chars, 0, i, j)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, boolean[][] visited, char[] chars, int start, int x, int y) {
        if(start == chars.length - 1 && board[x][y] == chars[start]) return true;
        if(board[x][y] != chars[start] || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        for (int i = 0; i < direction.length; i++) {
            int curX = x + direction[i][0];
            int curY = y + direction[i][1];
            if(curX >= 0 && curX < board.length && curY >= 0 && curY < board[0].length) {
                if(dfs(board, visited, chars, start + 1, curX, curY)) {
                    return true;
                }
            }
        }
        visited[x][y] = false;
        return false;
    }
}
