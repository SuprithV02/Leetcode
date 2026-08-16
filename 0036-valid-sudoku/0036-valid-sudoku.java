class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i = 0; i<9; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r = 0; r<9; r++){
            for(int c = 0; c<9; c++){

                char val = board[r][c];

                int boardIndex = (r/3)*3 + (c/3);

                if(val == '.') continue;

                if(row[r].contains(val) || col[c].contains(val) || boxes[boardIndex].contains(val)) return false;

                row[r].add(val);
                col[c].add(val);
                boxes[boardIndex].add(val);

            }

        }
            return true;
    }
}