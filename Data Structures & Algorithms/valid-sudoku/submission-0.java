class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {

                char currVal = board[i][j];
                int boxIndex = (i / 3) * 3 + (j / 3);

                if(currVal == '.') {
                    continue;
                } else if(!rows[i].add(currVal) || !cols[j].add(currVal) ||
                        !boxes[boxIndex].add(currVal)){
                    return false;
                }
            }
        }
        return true;
    }
}
