class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                char num = board[i][j];
                if(num != '.') {
                    if(!seen.add(num + " in row " + i) || !seen.add(num + " in col " + j) || !seen.add(num + " in cube " + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        return true;
        */
        for(int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !seen.add(board[i][j]))
                    return false;
            }   
        }
        for(int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.' && !seen.add(board[j][i]))
                    return false;
            }   
        }
     
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                HashSet<Character> seen = new HashSet<>();
                for(int k = 0; k < 9; k++) {
                    int x = i*3 + k/3;
                    int y = j*3 + k %3;
                    if(board[x][y] != '.' && !seen.add(board[x][y]))
                        return false;
                }
            }  
        }
        return true;
    }
}
